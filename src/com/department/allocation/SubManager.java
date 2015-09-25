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
public class SubManager extends TeamMember {
	List<Employee> qadevlprs = new ArrayList<Employee>(); 
	
	public SubManager(String name, double amount){
		super(name, amount);
	}
	
	@Override
	public void add(Employee emp) {
		qadevlprs.add(emp);
	}

	/*
	 * Sub Manager's Allocated amount is the sum 
	 * of all the team members down the hierarchy 
	 * reporting to the Sub Manager 
	 * */
	@Override
	public double getAllocatedAmount() {
		double amt = 0;
		Iterator<Employee> employeeIterator = qadevlprs.iterator();  
		while(employeeIterator.hasNext()){  
		  Employee employee = employeeIterator.next();  
		  amt = amt + (employee != null ? employee.getAllocatedAmount() : 0);  
		}
	 	return this.allocatedAmt + amt;
	}

	@Override
	public void remove(Employee emp) {
		Iterator<Employee> employeeIterator = qadevlprs.iterator();  
		while(employeeIterator.hasNext()){  
			   Employee employee = employeeIterator.next();  
			   if(null != employee 
					   && (emp.getName()).equals(employee.getName())) {
				   qadevlprs.remove(employee);
			   }  
			}
	}
}
