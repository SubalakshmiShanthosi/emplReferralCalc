package com.facilio.code.topEarners.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TopEarnersRank implements CalcReferralBonusImpl {

	//OrgForCheckReferal organisation;
	
	@Override
	public void calculateReferralBonus(OrgForCheckReferal organisation) {
    
	Integer directRefreeAmt=100;
	Integer indirectRefAmt=50;
	Integer thirdindirect=25;
	Integer bonus=0;
	organisation.setReferredByForEmp();
	System.out.println(" EMPLOYEE DETAILS:");
	System.out.println("--------------------------------------");
	organisation.printEmpDetails();
	System.out.println("--------------------------------------");
	ArrayList<Employee> employeeList=organisation.getEmployeeDO();
	for(int i=0;i<employeeList.size();i++)
	{
		Employee aEmp=employeeList.get(i);
		//Direct referee cost 
		bonus+=aEmp.getRefreesCount()*directRefreeAmt;
		//Indirect refree cost
		/*
		 * Get empl list of aEmp iterate and find their getRefreesCount
		 */
		bonus+=calculateBonusIndirect(aEmp, indirectRefAmt);
		//bonus+=calculateBonusIndirect(aEmp, refreeAmt)
		System.out.println("For Employee "+i+"Bonus is"+bonus);
	}
		System.out.println("TOTAL BONUS EXPENDITURE:"+bonus);
	}
	
	//Indirect refree cost
			/*
			 * Get empl list of aEmp iterate and find their getRefreesCount
			 */
	public Integer calculateBonusIndirect(Employee aEmpl,Integer refreeAmt)
	{ 
	    Integer bonus=0;
		ArrayList<Integer> refrees=aEmpl.getRefrees();
		for(int k=0;k<refrees.size();k++)
		{
			Employee indirectEmp=organisation.getEmployeeByID(refrees.get(k));
			if(indirectEmp!=null)
			{
				bonus+=indirectEmp.getRefreesCount()*refreeAmt;
			}
		
		}
		return bonus;
	}
	//Not needed 
	public void populateEmplDet(HashMap<Integer,ArrayList<Integer>>emplDet)
	{
		Set<Integer> keySet=emplDet.keySet();
		Iterator<Integer> iter=keySet.iterator();		
		// Initially setting the referredby as 0 indicating no one has referred them in inception - calculate in org wide
		while(iter.hasNext())
		{
			Integer empIden=iter.next();
			organisation.addEmployeeDetInOrg(getNewEmployeeDO(empIden,0,emplDet.get(empIden)));
		}
		
	}
	
	

	//TODO move it to Employee Class - relaxed cohesion found
   	public Employee getNewEmployeeDO(int uniID,int refferedByIden,ArrayList<Integer>refrees)
   	{
   	 return new Employee(uniID,refferedByIden,refrees);
   	}
}
