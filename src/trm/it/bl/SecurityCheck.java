package trm.it.bl;

import trm.it.jt.MyTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class SecurityCheck {
	public static boolean isUserValid(String username, String userpassword)
	{
		MyTemplate objTemplate = new MyTemplate();
		JdbcTemplate temp = objTemplate.getTemplate();
		
		//select count(*) from securitytable where userid=? and userpassword=?
		 int result = temp.queryForInt("select count(*) from securitytable where userid=? and userpassword=?",
				 new Object[]{username,userpassword});
		
		 if (result==1)
			 return true;
		 else
			 return false;
		 
	}
	public static void main()
	{ // test code
		SecurityCheck obj = new SecurityCheck();
		System.out.println(obj.isUserValid("901", "syntel123$"));

	}
}
