package com.studentpaymentapp;

public class TestStduentPaymentApp {

	public static void staffDetails() {
			boolean valid=false;
			System.out.println("--------------------------");
			System.out.println("1.SIGNIN\n2.REGISTER");
			int choice = 1;
			switch (choice) {
			case 1:
				valid = Staff.validate("9500500452","Suriya1@");
				break;
			case 2:
				valid = Staff.registerStaff("9738494944","Ajayst3#");
				break;
			default:
				System.out.println("Enter correct option");
			}
			if (valid) {
				System.out.println("--------------------------");
				//Staff.dispalyStaffList();
				staffDetails1();
			}
		
	}

	public static void staffDetails1() {
		System.out.println("------------------------");
		System.out.println("1.CHANGE PASSWORD\n2.ADD STUDENT ENTRY\n3.DELETE STUDENT ENTRY");
		System.out.println("--------------------------");
		int choice=3;
		switch(choice){
		case 1:
			Staff.changePassword("Harish1#","Viajayst4$");
			System.out.println("--------------------------");
		    //Staff.dispalyStaffList();
		    break;
		case 2:
			//Student.dispalyStudentDetails();
			Student.addStudentDetails("arvind","1712014","EEE","firstYear","9348473858","75000");
			System.out.println("--------------------------");
			//Student.dispalyStudentDetails();
		    break;
		case 3:
			Student.deleteStudentDetails("1712113");
			//Student.dispalyStudentDetails();
	        break;
		 default:System.out.println("Enter correct option");
		}
		

	}

	public static void studentDetails() {
		System.out.println("-------------------------");
		boolean isvalid=Student.studentValidater("1712113","8934842651");
		if(isvalid) {
			studentDetails1();
		}
	}
	
	
	public static void studentDetails1() {
		System.out.println("-------------------------");
		System.out.println("1.PAY FEES\n2.SHOW PERSONAL DETAILS\n3.SHOW ALL STUDENT DETAILS");
		System.out.println("-------------------------");
		int choice=1;
        switch(choice) {
        case 1:Student.Payment("1712113","70000");
               Student.dispalyStudentDetails();
               break;
        case 2:Student.dispalyPersonalDetail("1712113");
               break;
        case 3:Student.dispalyStudentDetails();
               break;
		 default:System.out.println("Enter correct option");
        
        }
		
		
		
	}

	public static void main(String[] args) {

		System.out.println("WELCOME TO STAFF STUDENT PAYMENT AND MANAGEMENT APP");
		System.out.println("1.STAFF\n2.STUDENT");
		int choice = 2;
		switch(choice) {
		case 1:staffDetails();
		       break;
		case 2:studentDetails();
		       break;
		 default:System.out.println("Enter correct option");
		}
		
		
	}

}
