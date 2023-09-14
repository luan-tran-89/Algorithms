
package com.algo.lab8.universal_hashing2;

import java.util.LinkedList;

public class Record {
	public static final int MAX_EMPLOYEE_NUM = 999999;
	private AddressInfo address;
	private WorkInfo workinfo;
	private int employeeNumber;
	

	public Record(AddressInfo a, WorkInfo w, int empnum){
		address = a;
		workinfo = w;
		employeeNumber = empnum;
		
	}	

	public AddressInfo getAddress() {
		return address;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}


	public WorkInfo getWorkinfo() {
		return workinfo;
	}
	

	

}
