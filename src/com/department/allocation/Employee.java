/**
 * Employee - can be Manager or Sub Manager or Team Lead or Developer or QA or any team member
 */
package com.department.allocation;

/**
 * @author chowdarym
 *
 */
public interface Employee {
	
	/** For adding team members will be used down the hierarchy **/
	public void add(Employee emp);
	
	/** For removing team members**/
	public void remove(Employee emp);
	
	/** Employee Name **/
	public String getName();
	
	/** Allocated Amount of Employee **/
	public double getAllocatedAmount();
}
