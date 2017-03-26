package com.aaron.exer.controller;

import com.aaron.exer.bean.UserBean;
import com.aaron.exer.date.DateFormatter;
import com.aaron.exer.util.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by AaronC on 3/26/2017.
 */

@Controller
public class UserController {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private MailClient mailClient;

    @Value("${spring.mail.targetAddress}")
    private String userBucketPath;

    @RequestMapping(value="/user",method= RequestMethod.GET)
    public String getUserPage(UserBean userBean){
        return "userHtml";
    }

    @RequestMapping(value="/user/submit",method= RequestMethod.POST)
    public String userSubmit(@Valid UserBean userBean, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "userHtml";
        }

        return "success";
    }

    @ModelAttribute("dateFormat") public String localeFormat(Locale locale) {
        return DateFormatter.getPattern(locale);
    }

    @RequestMapping(value="/admin",method= RequestMethod.GET)
    public String getAdminPage(){

        try {
            taskExecutor.execute(new Runnable() {
                public void run() {
//                    mailClient.prepareAndSend("cratercreater@gmail.com","Admin login");
                    System.out.println(userBucketPath);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "admin";
    }

    @RequestMapping(value="/adminLogin",method= RequestMethod.GET)
    public String getAdminLoginPage(){
        return "adminLogin";
    }

}
