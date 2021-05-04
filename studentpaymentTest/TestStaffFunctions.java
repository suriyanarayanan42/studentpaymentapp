package com.studentpayment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStaffFunctions {
     @Test
     public void testRegisterStaff() {
    	 boolean isvalid=Staff.registerStaff("9876543218","Ajayst1$");
    	 assertEquals(true,isvalid);
    	 //Staff.dispalyStaffList();
	 }

     @Test
     public void testChangePassword() {
    	 boolean isvalid=Staff.changePassword("Harish1#","vIjaytd4@");
    	 assertEquals(true,isvalid);
    	 //Staff.dispalyStaffList();

     }
     @Test
     public void testAddStudentDetails() {
    	 boolean isvalid=Student.addStudentDetails("arvind","1712114","CSE","FinalYear","8459345787","75000");
    	 assertEquals(true,isvalid);
    	 //Student.dispalyStudentDetails();
    	 
     }




}
