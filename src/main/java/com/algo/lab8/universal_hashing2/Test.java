package com.algo.lab8.universal_hashing2;

public class Test {
	static String n = System.getProperty("line.separator");

	static void collisionsNotUniversal() {
		System.out.println("Collisions with universal hashing: "+n+n);
		SepChainHashTable table = null;  
		int tablesize = 169;
		HashFunction h = null;
		for(int round = 0; round < 50; ++round ){
			table = new SepChainHashTable(tablesize,true);
			int nextNum = 0;
			for(int i = 0; i < 500; ++i){
				//this produces numbers between 100,000 and 1,000,000
				nextNum = (RandomNumbers.getRandomInt(100000,1000000) /13)*13;
				
				
				table.put(nextNum, new Record(new AddressInfo(),new WorkInfo(),nextNum));
			}
			//test num collisions on an insertion
			//System.out.println("Test for round "+round);
			nextNum = (RandomNumbers.getRandomInt(100000,1000000)/13)*13;
			
			table.putDisplayCollisions(nextNum,new Record(new AddressInfo(),new WorkInfo(),nextNum));
		}
		System.out.println("Collisions record: ");
		System.out.println(table.collisionCount);			
		
		
	}
	public static void main(String[] args) {
		collisionsNotUniversal();
		
		//collisionsUniversal();
	}
}
