package com.studentpayment;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStaffValidate {
     
	 @Test
	 public void testMobNo() {
		 Staff.dispalyStaffList();
		 boolean isvalid=Staff.mobNoValidater("9500500452");
		 assertEquals(true,isvalid);
	 }
	 @Test
	 public void testPassword() {
		 boolean isvalid=Staff.passwordValidater("Harish1#");
		 assertEquals(true,isvalid);
	 }
     @Test
     public void testStudentValidate() {
    	 boolean isvalid=Staff.validate("9003750359","Harish1#");
    	 assertEquals(true,isvalid);
     }
    


}
