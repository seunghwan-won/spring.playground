package cc.ewqr.spring.playground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String welcome(Model model) throws InterruptedException {
        Date today = new Date();
        model.addAttribute("today", today);
        Thread.sleep(1999);
        return "welcome";
    }



}
