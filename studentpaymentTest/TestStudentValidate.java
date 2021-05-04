package com.studentpayment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestStudentValidate {
     @Test
     public void testStudentValidation() {
    	 boolean isvalid=Student.studentValidater("1712113","8934842651");
    	 assertEquals(true,isvalid);
     }
     @Test
     public void testPayment() {
    	 Student.Payment("8934842651","40000");
    	 String isvalid=Student.Payment("8934842651","40000");
    	 assertEquals("paid",isvalid);
    	 Student.dispalyStudentDetails();

     }
}
