package com.studentpaymentapp;

import java.util.ArrayList;

public class Student {
    static ArrayList<StudentDetails> studentList=new ArrayList<StudentDetails>();
    //Default student Details
    static {
    	StudentDetails stud1=new StudentDetails();
    	stud1.name="sundar";
    	stud1.rollNo=1712113L;
    	stud1.department="ECE";
    	stud1.year="thirdYear";
    	stud1.mobNo=8934842651L;
    	stud1.fees=80000;
    	
    	StudentDetails stud2=new StudentDetails();
    	stud2.name="samuel";
    	stud2.rollNo=1712116L;
    	stud2.department="MECH";
    	stud2.year="secondYear";
    	stud2.mobNo=9276435673L;
    	stud2.fees=95000;
    	
    	
    	studentList.add(stud1);
    	studentList.add(stud2);

    }
    
    
    /**
     *Display  All Student Details
     * 
     */
    public static void dispalyStudentDetails() {
    	for(StudentDetails student:studentList) {
    		System.out.println("Name:"+student.name+" RollNo:"+student.rollNo+" Department:"+student.department+" Year:"+student.year+" MobNo:"+student.mobNo+" Fees:"+student.fees+" Payment Details:"+student.paymentDetails);
    	}
    }
    
  
    /**
     *Display Individual Student Personal Detail
     *
     * @param rollNo
     */
    public static void dispalyPersonalDetail(String rollNo){
    	boolean Exist=false;
    	boolean rollNoValid=Staff.rollNoValidater(rollNo);
    	if(rollNoValid) {
    	  for(StudentDetails student:studentList) {
    	    if(student.rollNo==Long.valueOf(rollNo)){
    	      System.out.println("Name:"+student.name+" RollNo:"+student.rollNo+" Department:"+student.department+" Year:"+student.year+" MobNo:"+student.mobNo+" Fees:"+student.fees+" Payment Details:"+student.paymentDetails);
    	      Exist=true;
    	      break;
    	    }
    	 }
    	  if(!Exist)
      	{
      		System.out.println("RollNo Does Not Exist");
      	}
    	  
    	}else {
    		System.out.println("Enter valid roll numnber");
    	}
    	
    }
    
    
    /**
     *Staff Add Student Data Entry Before it checks valid mobile number
     *
     * @param name
     * @param rollNo
     * @param department
     * @param year
     * @param mobNo
     * @param fees
     */
	public static boolean addStudentDetails(String name,String rollNo,String department,String year,String mobNo,String fees) {
		boolean isValidMobNo=Staff.mobNoValidater(mobNo);
		boolean isValidRollNo=Staff.rollNoValidater(rollNo);
        boolean isValidFee=feesValidater(fees);
		boolean isSuccess=false;
		if(isValidMobNo && isValidFee && isValidRollNo){
	      boolean rollNoValid=searchRollNo(rollNo);
		  if(!rollNoValid) {
			StudentDetails stud=new StudentDetails();
			stud.name=name;
			stud.rollNo=Long.valueOf(rollNo);
			stud.department=department;
			stud.year=year;
			stud.mobNo=Long.valueOf(mobNo);
			stud.fees=Integer.valueOf(fees);
			
			studentList.add(stud);
			isSuccess=true;
			System.out.println("Student Entry Added Successfully");	
			
		  }else {
			System.out.println("Enter 10-Digit Mobile Number--//Valid RollNo//--Valid Fees Amount");	
			}
		}else {
			System.out.println("Roll Number already exist");
		}
		return isSuccess;
	}
	
	
	
	/**
	 * Before deleting student details its checks whether number exist or not
	 * @param mobNo
	 * @return
	 */
	public static boolean deleteStudentDetails(String rollNo) {
		boolean isDeleted=false;
		boolean isValidRollNo=Staff.rollNoValidater(rollNo);
		if(isValidRollNo) {
			boolean isRollNoExist=searchRollNo(rollNo);
            if(isRollNoExist) {
			  for(StudentDetails student:studentList) {
				if(student.rollNo==Long.valueOf(rollNo)) {
					studentList.remove(student);
					isDeleted=true;
					System.out.println("Student Entry deleted Successfully");	
					break;
				  }
			  }
		    }else{
			System.out.println("Roll Number does not exist");
		     }
         }else{
			System.out.println("Enter valid Roll Number ");
		    }
		return isDeleted;
			
		}

  
	/**
	 *Student Validation Before it checks valid Mobile Number
	 *
	 * @param rollNo
	 * @param MobNo
	 */
	public static boolean studentValidater(String rollNo,String mobNo){
		boolean isSuccess=false;
		boolean mobValid=Staff.mobNoValidater(mobNo);
		boolean rollValid=Staff.rollNoValidater(rollNo);
		boolean isExist=false;
		if(mobValid && rollValid){
		for(StudentDetails student:studentList) {
		if(student.rollNo==Long.valueOf(rollNo) && student.mobNo==Long.valueOf(mobNo))
		{
			isExist=true;
			isSuccess=true;
            break;
			}
		}
		if(isExist) {
			System.out.println("login success");
		}else {
			System.out.println("Invalid Login////Wait Staff Upload Your Profile");
		}
		
		}else {
			System.out.println("Enter 10-Digit Number--//Valid RollNo");
			}
		return isSuccess;
	}
	
	/**
	 * searches for Mobile Number
	 * @param mobNo
	 * @return
	 */
	public static boolean searchMobNo(String mobNo){     
		boolean exist=false;
		for(StudentDetails student:studentList) { 
			if(student.mobNo==Long.valueOf(mobNo))
			{
			exist=true;
			break;
			}
		}
		return exist;
	}
	
	
     public static boolean searchRollNo(String rollNo) {
		boolean isExist=false;
		for(StudentDetails student:studentList) {
			if(student.rollNo==Long.valueOf(rollNo)) {
				isExist=true;
				break;
			}
		}
		return isExist;
	}
	
	
	
	/**
	 * checks for fees valid
	 * @param fees
	 * @return
	 */
	public static boolean feesValidater(String fees) {             
		boolean isFeeValid=false;
		try {                                 
			int fee=Integer.parseInt(fees);
			if(fee>0) {
				isFeeValid=true;
			}
		}catch(Exception e)
		{
			isFeeValid=false;
		}
		return isFeeValid;
	}
    
	
	/**
	 * Before Fees Payment checks for number
	 * @param fees
	 * @param rollNo
	 */
	public static String Payment(String rollNo,String fees) {
		String billDetails=null;
		boolean rollNoValid=Staff.rollNoValidater(rollNo);
		boolean isFeeValid=feesValidater(fees);
        if(rollNoValid&&isFeeValid) {
		boolean isRollNoExist=searchRollNo(rollNo);
		if(isRollNoExist){
    	for(StudentDetails student:studentList) {
    	  if(student.rollNo==Long.valueOf(rollNo)){
    		  if(Integer.valueOf(student.fees)!=0) {
    		   if(Integer.valueOf(student.fees)>=Integer.valueOf(fees)){
    		     student.fees=(Integer.valueOf(student.fees)-Integer.valueOf(fees));
    		     if(Integer.valueOf(student.fees)==0){
    		       student.paymentDetails="paid";
    		       billDetails=student.paymentDetails;
   	    	       System.out.println("Payment Succesfull");
   	    	       }else {
    		    	 student.paymentDetails="pending";
    		    	 billDetails=student.paymentDetails;
    		    	 System.out.println("Payment Succesfull");
    		         }
    		    }else {
    		     System.out.println("Enter Correct Payment//payment to pay:"+student.fees);
    		     }
    	      }else {
    	    	  System.out.println(" Already paid");
    		      student.paymentDetails="paid";
    		      billDetails=student.paymentDetails;
    		  }
    	  }
    	 }
    	}else {
    		System.out.println(" Roll number Does not Exist");
    	}
		
	}else {
		System.out.println("Enter Valid RollNo or Valid Fees ");
	}
        return billDetails;
	}
	
}
