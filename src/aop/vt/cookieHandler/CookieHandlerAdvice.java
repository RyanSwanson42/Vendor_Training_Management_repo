package aop.vt.cookieHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieHandlerAdvice {
	
	public void setCookie(CookieHandlerPojo cook,HttpServletResponse response){
		
		Cookie setUser = new Cookie("un",cook.getUsername());
		Cookie setPass =  new Cookie("up", cook.getPassword());
		setUser.setMaxAge(60*60*24);
		setPass.setMaxAge(60*60*24);
		response.addCookie(setUser);
		response.addCookie(setPass);
		System.out.println("cookies are set :) Smiley face big man");

		
	}

}
