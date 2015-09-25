/**
 * 
 */
package com.department.allocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chowdarym
 *
 */
public class Manager extends TeamMember {
	List<Employee> subManagers = new ArrayList<Employee>(); 
	
	public Manager(String name, double amount) {
		super(name, amount);
	}
	
	@Override
	public void add(Employee emp) {
		subManagers.add(emp);
	}

	/*
	 * As the Manager is at the higher level 
	 * the allocated amount would be 
	 * the sum of all the team members down the hierarchy 
	 * whose allocated amount is included in the submanager's allocated amount 
	 * and the amount allocated for the Manager
	 * */
	@Override
	public double getAllocatedAmount() {
		double amt = 0;
		Iterator<Employee> employeeIterator = subManagers.iterator();  
		while(employeeIterator.hasNext()){  
		   Employee employee = employeeIterator.next();  
		   amt = amt +( employee != null ? employee.getAllocatedAmount() : 0 );  
		}  
		return allocatedAmt + amt;
	}
	
	@Override
	public void remove(Employee emp) {  
		Iterator<Employee> employeeIterator = subManagers.iterator();  
		while(employeeIterator.hasNext()){  
		   Employee employee = employeeIterator.next();  
		   if(null != employee 
				   && (emp.getName()).equals(employee.getName())) {
			   subManagers.remove(employee);
		   }  
		}
	}
}