/**
 * 
 */
package com.department.allocation;

/**
 * @author chowdarym
 *
 */
public class TeamMember implements Employee {
	private String name;
	protected double allocatedAmt;
	 
	public TeamMember(String name, double amount){
		this.name = name;
		this.allocatedAmt = amount;
	}
	
	@Override
	public void add(Employee emp) {
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getAllocatedAmount() {
	 	return this.allocatedAmt;
	}

	@Override
	public void remove(Employee emp) {
	}
}