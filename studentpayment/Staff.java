package com.studentpayment;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Staff {
	static ArrayList<StaffDetails> staffList=new ArrayList<StaffDetails>();	//to store staff data in staffDetail class

	//Default staff Details
	static {                                      
		StaffDetails st1=new StaffDetails();
		st1.mobNo=9500500452L;
		st1.password="Suriya1@";
		
		StaffDetails st2=new StaffDetails();
		st2.mobNo=9003750359L;
		st2.password="Harish1#";
		
		staffList.add(st1);
		staffList.add(st2);
		}
	
	
	/**
	 * This method is used to display Stored staff details stored in arraylist
	 * 
	 * 
	 * 
	 */
	public static void dispalyStaffList(){    
		for(StaffDetails staff:staffList) {
		System.out.println("mobNo:"+staff.mobNo+"  password:  "+staff.password);	
		}
	}
	

	/**
	 * Adding new staff details to staffDetails class or Registering staff details
	 * Before it checks Mobile Number  and Password Format
	 * @param mobNo
	 * @param password
	 */
    public static boolean registerStaff(String mobNo,String password) {     
		boolean isSuccess=false;
		boolean isValidMobNo=mobNoValidater(mobNo);  
		boolean isValidPassword=passwordValidater(password);
		if(isValidMobNo && isValidPassword){
			boolean isMobNoExist=searchMobNo(mobNo);
			boolean isPassExist=searchPassword(password);
		    if(!isMobNoExist && !isPassExist) {	
		    StaffDetails st=new StaffDetails();	
		    st.mobNo=Long.parseLong(mobNo);
		    st.password=password;
		    staffList.add(st);
		    System.out.println("Registration Successfull");
		    isSuccess=true;
		    }else {
		    System.out.println("Mobile number and password already exist");	
		    }
		}else {
		 	System.out.println("Enter 10-Digit Number////Enter Corect Pattern For Password");
		    }
	  return isSuccess;
	}
    
	
	/**
	 * Searching  password in staffList
	 * @param password
	 * @return
	 */
	public static boolean searchPassword(String password){     
		boolean exist=false;
		for(StaffDetails staff:staffList) {
			if(staff.password.equals(password))
			{
			exist=true;
			break;
			}
		}
		return exist;
	}
	
	
	/**
	 * Searching Mobile Number in staffList
	 * @param MobNo
	 * @return
	 */
	public static boolean searchMobNo(String MobNo) {
		
		boolean exist=false;
		for(StaffDetails staff:staffList) {
			if(staff.mobNo==Long.valueOf(MobNo)) {
				exist=true;
				break;
			}
		}
		return exist;
	}
	
	
	/**
	 * To remove old password and add new password in staff Details Before it checks for valid password
	 * and searches for password in class 
	 * 
	 * @param oldPassword
	 * @param newPassword
	 */
	public static boolean changePassword(String oldPassword,String newPassword){ 
		boolean isSuccess=false;
		boolean passwordValid=passwordValidater(newPassword);
		if(passwordValid) {
		boolean isExist=searchPassword(oldPassword);
		if(isExist) {
		for(StaffDetails staff:staffList) {
		if(staff.password.equals(oldPassword))
		{
			staff.password = newPassword;
			System.out.println("Password sucessfully Changed");	
			isSuccess=true;
			break;
		}
		}}else {
		System.out.println("Password Does Not Exist");	
		}
		}else {
		System.out.println("Enter Valid Password");
		}
		return isSuccess;
	}
	
	
	/**
	 * Mobile Number Checker(10-digit number)
	 * 
	 * @param mobNo
	 * @return
	 */
	public static boolean mobNoValidater(String mobNo) {             
		boolean isMobNoValid=false;
		try {                                 
			long mobNumber=Long.parseLong(mobNo);
			if(mobNo.length()==10) {
				isMobNoValid=true;
			}
		}catch(Exception e)
		{
			isMobNoValid=false;
		}
		return isMobNoValid;
	}
	
	
	
	public static boolean rollNoValidater(String rollNo) {             
		boolean isRollNoValid=false;
		try {                                 
			long rollNumber=Long.parseLong(rollNo);
			if(rollNo.length()==7) {
				isRollNoValid=true;
			}
		}catch(Exception e)
		{
			isRollNoValid=false;
		}
		return isRollNoValid;
	}
	
	
	/**
	 * Password Checker-password format((0-9)(a-z)(A-Z)[@#$%])
	 * 
	 * 
	 * @param password
	 * @return
	 */
	public static boolean passwordValidater(String password) {      
	    boolean isPassValid=true;
		String check="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$";
		Pattern p=Pattern.compile(check);
		Matcher m=p.matcher(password);		
		if((password==null)||(password.trim().equals(""))||!m.matches())
		{
			isPassValid=false;
		}
	   return isPassValid;	
	}

	
	/**
	 * Before Validation it checks Mobile Number and Password Format then validates
	 *  
	 * @param mobNo
	 * @param password
	 */
	//mobile number and password validates
	public static boolean validate(String mobNo,String password) {              
		boolean mobNoValid=mobNoValidater(mobNo);                
		boolean passwordValid=passwordValidater(password);
		boolean exist=false;
        if(mobNoValid&&passwordValid){
		for(StaffDetails staff:staffList){
		if((staff.mobNo==Long.parseLong(mobNo))&&(staff.password.equals(password))){
			exist=true;
		}}
		if(exist){
		System.out.println("successfully logged in");
		}else {
		System.out.println("invalid login");
		}
		}else {
		System.out.println("Enter 10-Digit Number////Enter Corect Pattern For Password");
        }
        return exist;
		}


	
}