package com.facilio.code.topEarners.core;

import java.util.ArrayList;

public class OrgForCheckReferal {

	private ArrayList<Employee>employees;
	
	public void setReferredByForEmp()
	{
		for(int i=0;i<employees.size();i++)
		{
			Employee aEmp=employees.get(i);
			for(int k=i+1;k<=employees.size();k++)
			{
				ArrayList<Integer>refrees=employees.get(k).getRefrees();
				if(refrees.contains(aEmp.getUniqueIden()))
				{
					aEmp.setRefferedBy(employees.get(k).getUniqueIden());
					
				}
			}
		}
	}
	
	public void addEmployeeDetInOrg(Employee aEmp)
	{
		employees.add(aEmp);
	}
	
	public ArrayList<Employee> getEmployeeDO()
	{
	 return employees;
	}
	
	public Employee getEmployeeByID(int uniqueID)
	{
		for(int i=0;i<employees.size();i++)
		{
			if(employees.get(i).getUniqueIden()==uniqueID)
			{
				return employees.get(i);
			}
		}
		return null;
	}
	
	public void printEmpDetails()
	{ 
		ArrayList<Employee> employees=getEmployeeDO();
		for(int i=0;i<employees.size();i++)
		{
			Employee aEmp=employees.get(i);
			System.out.println("EMPLOYEE DETAILS:");
			System.out.println("---------------------------------------");
			System.out.println("Empl ID:"+aEmp.getUniqueIden());
			System.out.println("Empl Referred By:"+aEmp.getReferredBy());
			System.out.println("Get Refrees list:"+aEmp.getRefrees());
			System.out.println("--------------------------------------");
			
		}
	}
}
