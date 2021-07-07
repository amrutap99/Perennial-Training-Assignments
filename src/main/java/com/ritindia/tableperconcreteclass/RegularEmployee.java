package com.ritindia.tableperconcreteclass;

public class RegularEmployee extends Employee {
	
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + "]";
	}
	
	

}
