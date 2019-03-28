package bl;

import jt.MyTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterNewUser {

	public static void main(String s[])
	{ // test code
		//String ss[] = new RegisterNewUser().newRegister("Bob", "1234567890", "Phoenix", "Checking");
		//System.out.println("Customer new ID :" + ss[0] +  "\nNew Account number :" + ss[1]);
	}
	
	public String[] newRegister(String custName, String custPhone, String custCity, String accType)
	{
		String message[] = new String[2];
		MyTemplate objTemplate = new MyTemplate();
		JdbcTemplate temp = objTemplate.getTemplate();
		
		int accNum = temp.queryForInt("select acc_seq.nextval from dual");
		int custNum = temp.queryForInt("select cust_seq.nextval from dual");
		
		int resultForCustomer = temp.update("insert into customer values(?,?,?,?)", new Object[]{custNum,custName,custCity,custPhone});

		
		if (resultForCustomer>0)
		{
			int resultForAccount = temp.update("insert into account values(?,?,0,?)", new Object[]{accNum,accType,custNum});

			if(resultForAccount>0)
			{
				int resultForSecurity = temp.update("insert into securitytable values(?,?)", new Object[]{custNum,"syntel123"});
				
				if (resultForSecurity>0)
				{
					message[0]=custNum+"";
					message[1]=accNum+"";
					return message;
				}
			}
		}
		return null;
	}
	 
}
