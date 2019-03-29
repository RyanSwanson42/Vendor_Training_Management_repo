package trm.pm.bl;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.pm.dbo.EmployeeDAO;
import trm.pm.jt.MyTemplate;

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
	public boolean checkNewPassword(String userName,String pass1, String pass2) {
        EmployeeDAO ed = new EmployeeDAO();
        if (pass1.equals(pass2)) {ed.updatePassword(userName,pass1);return true;}

        return false;

    }
}