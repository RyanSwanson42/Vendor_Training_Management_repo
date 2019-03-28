package trm.pm.bl;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.pm.jt.MyTemplate;

public class NewCustomerRegistration {

	
	public static void main(String s[])
	{
		String ss[]= new NewCustomerRegistration().registerNewCustomer("Uday", "67788555", "Phoenix", "SA");
		System.out.println(ss[0] + "   " + ss[1]);
	}
	
	
	public String[] registerNewCustomer(String custName,String custPhone,String custCity,String typeofAccount)
	{
		String message[]=new String[5];
		
		MyTemplate template = new MyTemplate();
		JdbcTemplate temp = template.getTemplate();
		
		int newaccno = temp.queryForInt("select accseq.nextval from dual");
		int newcustid = temp.queryForInt("select custseq.nextval from dual");
		
		int resultForAccount = temp.update("insert into account values(?,?,7000)",
				new Object[]{newaccno,typeofAccount});
		
		if(resultForAccount>0)
		{
			int resultForCustomer = temp.update("insert into Customer values(?,?,?,?,?)",
					new Object[]{newcustid,custName,custPhone,custCity,newaccno});
			
			System.out.println("--------------------1");
			
			if(resultForCustomer>0)
			{
				System.out.println("--------------------2");
				
				int resultForSecurity = temp.update("insert into SecurityTable values(?,'syntel123')",
						new Object[]{newcustid});
				
				if(resultForSecurity>0)
				{
					System.out.println("--------------------1");
					message[0]=newcustid+"";
					message[1]=newaccno+"";
					return message;
				}
			}
			
		}
		return message;
		
	}
}