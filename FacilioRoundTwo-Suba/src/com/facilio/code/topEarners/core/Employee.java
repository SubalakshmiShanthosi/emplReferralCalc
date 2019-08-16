package com.facilio.code.topEarners.core;

import java.util.*;
public class Employee {
 
	private int uniIdentifier;
	//Person who referred followed by the list of refrees
   	private int refferedBy;
   	private ArrayList<Integer>refrees;
   	
   	public Employee(int iden,int refBy,ArrayList<Integer> refreesList) {
		uniIdentifier=iden;
		refferedBy=refBy;
		refrees=refreesList;
	}
   	
   	
   	public void setEmployeeInterfaceDet(int identifier,ArrayList<Integer> ref)
   	{
   		uniIdentifier=identifier;
   		refrees=ref;
   	}
   	
   	public ArrayList<Integer> getRefrees()
   	{
   		return refrees;
   	}
   	
   	public void setRefferedBy(int refByIden)
   	{
   		refferedBy=refByIden;
   	}
   	
   	public int getUniqueIden()
   	{
   		return uniIdentifier;   	
    }
   	
   	public int getReferredBy()
   	{
   		return refferedBy;
   	}
   	
   	public Employee getNewEmployeeDO(int uniID,int refferedByIden,ArrayList<Integer>refrees)
   	{
   	 return new Employee(uniID,refferedByIden,refrees);
   	}
   	
   	public int getRefreesCount()
   	{
   		return refrees.size();
   	}
   	
}