package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.RTSUser;
import com.mercury.beans.RTSUserInfo;
import com.mercury.service.RegistrationService;
import com.mercury.utils.RegistrationUtil;

@Path("/registration")
public class RegistrationResource {
	private RegistrationService rs;
	
	public RegistrationResource() {
		if (rs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			rs = (RegistrationService)actx.getBean("RegistrationService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RTSUserInfo execute(
			@FormParam("username") String userid,
			@FormParam("password") String password,
			@FormParam("fname") String fname,
			@FormParam("lname") String lname,
			@FormParam("birthday") String birthday,
			@FormParam("email") String email) throws NoSuchAlgorithmException {
		RTSUser rtsuser = new RTSUser();
		rtsuser.setUserID(userid);
		rtsuser.setPassword(RegistrationUtil.md5(password));
		rtsuser.setFname(fname);
		rtsuser.setLname(lname);
		rtsuser.setBirthday(RegistrationUtil.setBirthdayFormat(birthday));
		rtsuser.setEmail(email.toLowerCase());
		rtsuser.setStatus(1);
		rtsuser.setAuthority("ROLE_USER");
		return rs.process(rtsuser);
	}
	
	@GET
	@Path("/checkusernameunique")
	@Produces({MediaType.TEXT_HTML})
	public String execute(
			@QueryParam("name") String userid
			) throws NoSuchAlgorithmException {
		//System.out.println("INPUT" + userid);
		return rs.isUniqueUserName(userid);
	}
}
