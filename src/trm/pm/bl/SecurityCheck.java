package trm.pm.bl;

import trm.pm.jt.MyTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class SecurityCheck {
	public static boolean isUserValid(String username, String userpassword)
	{
		MyTemplate objTemplate = new MyTemplate();
		JdbcTemplate temp = objTemplate.getTemplate();
		//System.out.println(username + " " + userpassword);
		int result = temp.queryForInt("select count(*) from employee where user_name=? "
				+ "and password=?",
				new Object[]{username,userpassword});
		System.out.println(result);
		if(result==1)
			return true;
		else
			return false;
	}
	public static void main(String s[])
	{
	//	SecurityCheck obj = new SecurityCheck();
	//	System.out.println(obj.isUserValid("901", "syntel123"));
	}
}