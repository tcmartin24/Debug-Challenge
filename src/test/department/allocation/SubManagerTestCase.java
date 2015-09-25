/**
 * 
 */
package test.department.allocation;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.department.allocation.Developer;
import com.department.allocation.Employee;
import com.department.allocation.QualityAnalyst;
import com.department.allocation.SubManager;

/**
 * @author chowdarym
 *
 */
public class SubManagerTestCase {

	@SuppressWarnings("null")
	@Test
	public void testForNull() {
		Employee subManager = null ;
		try {
			subManager.getName();
		} catch (NullPointerException e) {
			Assert.assertTrue("Sub Manager is not yet assigned", true);
		}
	}
	
	@Test
	public void testSubManager() {
		Employee subManager ;
		try {
			subManager = new SubManager("Sub Manager One", 300);
			String name = subManager.getName();
			double allocated = subManager.getAllocatedAmount();
			Assert.assertTrue("testSubManager testcase pass: Name =" + name
					+ ", Allocated = " + allocated, true);
		} catch (Exception e) {
				fail("Test Case testSubManager failed, Unable to create Sub Manager");
		}
	}
	
	@Test
	public void testAssignDeveloperToSubManager() {
		Employee subManager;
		Employee developer;
		try {
			subManager = new SubManager("Sub Manager One", 300);
			developer = new Developer("Developer One", 1000);
			subManager.add(developer);
			
			Assert.assertTrue("testAssignDeveloperToSubManager testcase pass", true);
		} catch (Exception e) {
				fail("Test Case testAssignDeveloperToSubManager failed, Unable to assign Developer to Sub Manager");
		}
	}
	
	@Test
	public void testAssignMultipleDevelopersToSubManager() {
		Employee subManager;
		Employee developer1;
		Employee developer2;
		
		try {
			subManager = new SubManager("Sub Manager One", 300);
			developer1 = new Developer("Developer One", 1000);
			subManager.add(developer1);
			
			developer2 = new Developer("Developer Two", 1000);
			subManager.add(developer2);
			
			Assert.assertTrue("testAssignMultipleDevelopersToSubManager testcase pass", true);
		} catch (Exception e) {
				fail("Test Case testAssignMultipleDevelopersToSubManager failed, Unable to assign Multiple Developers to Sub Manager");
		}
	}
	
	@Test
	public void testAssignQAToSubManager() {
		Employee subManager;
		Employee qa;
		try {
			subManager = new SubManager("Sub Manager One", 300);
			qa = new QualityAnalyst("QA One", 500);
			subManager.add(qa);
			
			Assert.assertTrue("testAssignQAToSubManager testcase pass", true);
		} catch (Exception e) {
				fail("Test Case testAssignQAToSubManager failed, Unable to assign QA to Sub Manager");
		}
	}
	
	@Test
	public void testAssignMultipleQAsToSubManager() {
		Employee subManager;
		Employee qa1;
		Employee qa2;
		
		try {
			subManager = new SubManager("Sub Manager One", 300);
			qa1 = new QualityAnalyst("QA One", 500);
			subManager.add(qa1);
			
			qa2 = new QualityAnalyst("QA Two", 500);
			subManager.add(qa2);
			
			Assert.assertTrue("testAssignMultipleQAsToSubManager testcase pass", true);
		} catch (Exception e) {
				fail("Test Case testAssignMultipleQAsToSubManager failed, Unable to assign Multiple QAs to Sub Manager");
		}
	}
	
	@Test
	public void testAllocatedAmountTest() {
		Employee subManager ;
		Employee developer;
		Employee qa;
		
		try {
			subManager = new SubManager("Sub Manager One", 300);
			qa = new QualityAnalyst("QA One", 500);
			subManager.add(qa);
			developer = new Developer("Developer One", 1000);
			subManager.add(developer);
			
			String name = subManager.getName();
			double allocated = subManager.getAllocatedAmount();
			Assert.assertTrue("testAllocatedAmountTest Pass: Allocated "+allocated+" for Manager "+name, allocated == 1800);
		} catch (Exception e) {
				fail("Test Case testAllocatedAmountTest failed");
		}
	}
	
	@Test
	public void testRemoveDeveloper() {
		Employee subManager ;
		Employee developer;
		
		try {
			subManager = new SubManager("Sub Manager One", 300);
			developer = new Developer("Developer One", 1000);
			subManager.add(developer);
			subManager.remove(developer);
			double allocatedAmtAftrRem = subManager.getAllocatedAmount();
			
			Assert.assertTrue("testRemoveDeveloper testcase pass", allocatedAmtAftrRem == 300);
		} catch (Exception e) {
				fail("Test Case testRemoveDeveloper failed, Unable to remove developer");
		}
	}
	
	@Test
	public void testRemoveQualityAnalyst() {
		Employee subManager ;
		Employee qa;
		
		try {
			subManager = new SubManager("Sub Manager One", 300);
			qa = new QualityAnalyst("QA One", 500);
			subManager.add(qa);
			subManager.remove(qa);
			double allocatedAmtAftrRem = subManager.getAllocatedAmount();
			
			Assert.assertTrue("testRemoveQualityAnalyst testcase pass", allocatedAmtAftrRem == 300);
		} catch (Exception e) {
				fail("Test Case testRemoveQualityAnalyst failed, Unable to remove QualityAnalyst");
		}
	}

}
