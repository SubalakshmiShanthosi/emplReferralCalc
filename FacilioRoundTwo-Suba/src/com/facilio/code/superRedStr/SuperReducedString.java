package com.facilio.code.superRedStr;

import java.util.*;
public class SuperReducedString {

	public static String inputString;
	public static HashMap<Character,Integer>inpMapping;
	
	public SuperReducedString(String ainputStr) {
		inputString=ainputStr;
	}
	
	public static HashMap<Character,Integer>getNewInpMapping()
	{
		return new HashMap<Character,Integer>();
	}
	
	public static void createinputMapping(String ainputStr)
	{
		
        char[]charArrforInp=ainputStr.toCharArray();
        inpMapping=getNewInpMapping();
        for(char aLiteral:charArrforInp)
        { 
        	if(inpMapping.containsKey(aLiteral))
        	{
        		inpMapping.put(aLiteral,inpMapping.get(aLiteral)+1);
        	}
        	else
        	{
        		inpMapping.put(aLiteral,Integer.valueOf(1));
        	}
        }
    }
	
	public static String reduceString(String ainputStr)
	{
		createinputMapping(ainputStr);
	    //while(inpMapping.entrySet().iterator().hasNext())
	    //{
	    	
	    //}
		String outputStr="";
		Set<Character> keySet=inpMapping.keySet();
		Iterator<Character>iter=keySet.iterator();
		while(iter.hasNext())
		{
			Character aChar=iter.next();
			if(inpMapping.get(aChar)%2!=0)
			{
				outputStr+=aChar;
			}
		}
		//System.out.println("OP:"+outputStr);
		return outputStr;
	}
}
