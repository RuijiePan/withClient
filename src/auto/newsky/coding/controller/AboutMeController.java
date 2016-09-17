package auto.newsky.coding.controller;

import auto.newsky.coding.serviceImpl.TaskImpl;
import auto.newsky.coding.serviceImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by prj on 2016/9/16.
 */
@Controller
@RequestMapping("/keep/")
public class AboutMeController {
    @Autowired
    private UserImpl userService;

}
