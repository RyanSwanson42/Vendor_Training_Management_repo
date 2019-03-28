package bl;

import org.springframework.jdbc.core.JdbcTemplate;

import jt.MyTemplate;

public class SecurityCheck {
	
	public static boolean isUserValid(String username, String userpassword)
	{
		MyTemplate objTemplate = new MyTemplate();
		JdbcTemplate temp = objTemplate.getTemplate();
		
		//select count(*) from employee where userid=? and userpassword = ?
		
		int result = temp.queryForInt("select count(*) from employee where userid=? and userpassword = ?",
				new Object[]{username, userpassword});
		
		if(result == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
//		if(username.equals("jesus") && userpassword.equals("syntel123$"))
//			return true;
//		return false;
	}
	public static void main(String s[])
	{
//		SecurityCheck obj = new SecurityCheck();
//		System.out.println(SecurityCheck.isUserValid("12", "syntel123"));
	}
}
