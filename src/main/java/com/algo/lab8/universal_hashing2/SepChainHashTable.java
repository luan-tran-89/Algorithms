package com.algo.lab8.universal_hashing2;
import java.util.*;
/**
 * This is a custom-made separate chaining hashtable. It isn't
 * as efficient as Java's implementations, but it's easier to see
 * what's going on. Before getting or putting, the methods always
 * squeeze the hashcode into the range [0,..,tablesize-1]. This supports
 * the computation of universal family of hash functions . 
 */
public class SepChainHashTable {
	//if you set a HashFunction, this class will
	//use it; if not, it will use hashCode() of objects
    private HashFunction h;
        /**
         * Construct the hash table.
         */
	public SepChainHashTable( ){
        this( DEFAULT_TABLE_SIZE );
    }
	public void setHashFunction(HashFunction h) {
		this.h = h;
	}
        
	private int modTableSize(int hashcode) {
		int adjusted = hashcode % size;
        return adjusted;
    }

	public long size() {
		return size;
	}
	public SepChainHashTable(int s, boolean useExact){
		if(useExact) {
			size = s;
		}
		else {
			size = Primes.nextPrime(s);
		}
    	System.out.println("table size = "+size);
        theLists = new LinkedList[ size ];
        for( int i = 0; i < size; i++ )
            theLists[ i ] = new LinkedList( );		
	}
    /**
     * Construct the hash table.
     * @param size approximate table size.
     */
    public SepChainHashTable( int approxSize ){
     	this(approxSize,false);
 
    }
    /**
     * Insert into the hash table. If the item is
     * already present, then do nothing.
     * @param x the item to insert.
     */
    public void put( Object key, Object val ){
    	int hashcode = (h == null) ? key.hashCode() : h.hash(key);
      	int hashval = modTableSize(hashcode);
        LinkedList whichList = theLists[ hashval ];
        ListIterator it = whichList.listIterator();
        Pair next = null;
        while(it.hasNext()) {
          	next = (Pair)it.next();
           	if(key.equals(next.key)) return;
        }
        //key not found
        whichList.addFirst(new Pair(key,val));
    }
    public void putDisplayCollisions( Object key, Object val ){
        
    	int hashcode = (h == null) ? key.hashCode() : h.hash(key);
      	int hashval = modTableSize(hashcode);
        LinkedList whichList = theLists[ hashval ];
        collisionCount.append("Encountered "+whichList.size()+" collisions"+System.getProperty("line.separator"));
        ListIterator it = whichList.listIterator();
        Pair next = null;
        while(it.hasNext()) {
          	next = (Pair)it.next();
           	if(key.equals(next.key)) return;
        }
        //key not found
        whichList.addFirst(new Pair(key,val));
        }    

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove( Object key ){
        
    	int hashcode = (h == null) ? key.hashCode() : h.hash(key);
    	int hashval = modTableSize(hashcode);
	    LinkedList whichList = theLists[ hashval ];
	    Iterator it = whichList.listIterator();
	    Pair next = null;
	    Object nextKey = null;
	    while(it.hasNext()) {
		   next = (Pair)it.next();
		   nextKey = next.key;
		   if(nextKey.equals(key)) {
			  whichList.remove( next );
			  return;
		   }
	   }
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item, or null if not found.
     */
    public Object get( Object key ){
        
       int hashcode = (h == null) ? key.hashCode() : h.hash(key);
       int hashval = modTableSize(hashcode);
       LinkedList whichList = theLists[ hashval ];
       Iterator it = whichList.listIterator();
       Pair next = null;
       Object nextKey = null;
       while(it.hasNext()) {
		   next = (Pair)it.next();
		   nextKey = next.key;
           if(nextKey.equals(key)) {
               return next.val;
           }
       }
       //not found
       return null;
   }
    
    public String toString(){
    	StringBuffer buf = new StringBuffer("[");
    	if(theLists != null){
    		int len = theLists.length;
    		LinkedList nextList = null;
    		Iterator nextIt = null;
    		Pair nextPair = null;
    		for(int i = 0; i < len; ++i){
    			nextList = theLists[i];
    			nextIt = nextList.iterator();
    			while(nextIt.hasNext()){
    				nextPair = (Pair)nextIt.next();
    				buf.append(nextPair.key+"->"+nextPair.val+",");
    			}
    		}
    		 
    	}
    	String retVal = buf.toString();
    	retVal = retVal.substring(0,retVal.length()-1)+"]";
    	return retVal;
    }


   /**
    * Make the hash table logically empty.
    */
    public void clear( ){
        
            for( int i = 0; i < size; i++ )
                theLists[ i ].clear( );
    }
    


    private static final int DEFAULT_TABLE_SIZE = 101;

     /* The array of Lists. */
    private LinkedList [ ] theLists; 
    private int size;

    public LinkedList[] getTheLists() {
    	return theLists;
    }
    
    public static void main( String [ ] args ){
    	SepChainHashTable table = new SepChainHashTable();
    	table.put("h","hello");
    	table.put("g","goodbye");
    	System.out.println("Getting h..."+ table.get("h").toString());
    	System.out.println("Getting g..."+ table.get("g").toString());
    	System.out.println(table.toString());
    }
    static StringBuffer collisionCount= new StringBuffer();

    class Pair {
    	Object key;
    	Object val;
        Pair(Object k, Object v) {
        	key = k;
            val = v;
        }
        public boolean equals(Object o) {
		if(!(o instanceof Pair)) return false;
            Pair p = (Pair)o;
            return p.key.equals(key) && p.val.equals(val);
	   }
    }

}

