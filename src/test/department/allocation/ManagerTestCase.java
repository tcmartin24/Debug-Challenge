/**
 * 
 */
package test.department.allocation;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.department.allocation.Employee;
import com.department.allocation.Manager;
import com.department.allocation.SubManager;


/**
 * @author chowdarym
 * 
 */
public class ManagerTestCase {
	
	@SuppressWarnings("null")
	@Test
	public void testForNull() {
		Employee manager = null ;
		try {
			 manager.getName();
		} catch (NullPointerException e) {
			Assert.assertTrue("Manager is not yet assigned", true);
		}
	}
	
	@Test
	public void testAssignManager() {
		Employee manager ;
		try {
			manager = new Manager("Manager One", 300);
			String name = manager.getName();
			double allocated = manager.getAllocatedAmount();
			Assert.assertTrue("testAssignManager testcase pass: Name =" + name
					+ ", Allocated = " + allocated, true);
		} catch (Exception e) {
				fail("Test Case testAssignManager failed, Unable to assign Manager");
		}
	}
	
	@Test
	public void testAssignSubManagerToManager() {
		Employee manager ;
		Employee subManager;
		try {
			manager = new Manager("Manager One", 300);
			subManager = new SubManager("Sub Manager One", 300);
			manager.add(subManager);
			
			Assert.assertTrue("testAssignSubManagerToManager testcase pass", true);
		} catch (Exception e) {
				fail("Test Case testAssignSubManagerToManager failed, Unable to assign SubManager to Manager");
		}
	}
	
	@Test
	public void testAssignMultipleSubManagers() {
		Employee manager ;
		Employee subManager1;
		Employee subManager2;
		
		try {
			manager = new Manager("Manager One", 300);
			subManager1 = new SubManager("Sub Manager One", 300);
			manager.add(subManager1);
			subManager2 = new SubManager("Sub Manager Two", 300);
			manager.add(subManager2);
			Assert.assertTrue("testAssignMultipleSubManagers testcase pass", true);
		} catch (Exception e) {
				fail("Test Case testAssignMultipleSubManagers failed, Unable to assign Multiple SubManagers to Manager");
		}
	}
	
	@Test
	public void testAllocatedAmountTest() {
		Employee manager ;
		Employee subManager1;
		Employee subManager2;
		
		try {
			manager = new Manager("Manager One", 300);
			subManager1 = new SubManager("Sub Manager One", 300);
			manager.add(subManager1);
			subManager2 = new SubManager("Sub Manager Two", 300);
			manager.add(subManager2);
			String name = manager.getName();
			double allocated = manager.getAllocatedAmount();
			Assert.assertTrue("testAllocatedAmountTest Pass: Allocated "+allocated+" for Manager "+name, allocated == 900);
		} catch (Exception e) {
				fail("Test Case testAllocatedAmountTest failed");
		}
	}
	
	@Test
	public void testRemoveSubManager() {
		Employee manager ;
		Employee subManager1;
		Employee subManager2;
		
		try {
			manager = new Manager("Manager One", 300);
			subManager1 = new SubManager("Sub Manager One", 300);
			manager.add(subManager1);
			subManager2 = new SubManager("Sub Manager Two", 300);
			manager.add(subManager2);
			manager.remove(subManager2);
			
			double allocatedAmtAftrRem = manager.getAllocatedAmount();
			Assert.assertTrue("testRemoveSubManager testcase pass", allocatedAmtAftrRem == 600);
		} catch (Exception e) {
				fail("Test Case testRemoveSubManager failed, Unable to remove submanager");
		}
	}
	
}
