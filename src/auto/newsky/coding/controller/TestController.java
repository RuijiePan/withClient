/*
package auto.newsky.coding.controller;

import auto.newsky.coding.po.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import auto.newsky.coding.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
    private TestService testServiceImpl;
	
	@RequestMapping("/testTransaction")
	public String testTransaction() throws Exception {
		log.error("testTransaction-----------------------------");
		User newUser = new User();
		newUser.setUserPassword("aaaa");
		newUser.setUserMobilephone("10086");
		testServiceImpl.addUser(newUser);
		
		return "login";
	}

}
*/
