import com.facilio.code.superRedStr.*;
import com.facilio.code.topEarners.core.Employee;
import com.facilio.code.topEarners.core.OrgForCheckReferal;
import com.facilio.code.topEarners.core.TopEarnersRank;

import java.util.*;
public class FacilioRoundTwoSuba {

	public static void main(String[] args) {
		/*
		//System.out.println("Hello");
        Scanner inputScan=new Scanner(System.in);
        String inputStr=inputScan.nextLine();	
        SuperReducedString srStr=new SuperReducedString(inputStr);
        //SuperReducedString.createinputMapping(inputStr);
        System.out.println(SuperReducedString.reduceString(inputStr));
	*/
		
		Scanner inpScanner=new Scanner(System.in);
		int totRefferalAct=inpScanner.nextInt();
		int emplID = 0;
		ArrayList<Integer> emplRefrees = null;
		OrgForCheckReferal orgIns=new OrgForCheckReferal();
		for(int i=0;i<totRefferalAct;i++)
		{
			emplID=inpScanner.nextInt();
			emplRefrees=new ArrayList<>();
			int countRef=inpScanner.nextInt();
			for(int k=0;k<countRef;k++)
			{
			  emplRefrees.add(inpScanner.nextInt());	
			}
			Employee empl=new Employee(emplID,0,emplRefrees);
			orgIns.addEmployeeDetInOrg(empl);
		}
		
		TopEarnersRank rankEmpl=new TopEarnersRank();
		System.out.println("Calculating referral bonus for employees");
		rankEmpl.calculateReferralBonus();
	}

}
