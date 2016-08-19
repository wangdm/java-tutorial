package com.wangdm.tutorial.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @RequestMapping(value="/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    
    @RequestMapping(value="/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView model = new ModelAndView("login");
        return model;
    }
    
    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().setAttribute("curuser", null);
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    
    @RequestMapping(value="/member")
    public ModelAndView member(HttpServletRequest request){
        ModelAndView model = new ModelAndView("member");
        String username = (String)(request.getSession().getAttribute("curuser"));
        if(username!=null && !"".equals(username)){
            logger.info("Login user is " + username);
            model.addObject("username", username);
        }else{
            logger.warn("No user login!");
        }
        return model;
    }

}
