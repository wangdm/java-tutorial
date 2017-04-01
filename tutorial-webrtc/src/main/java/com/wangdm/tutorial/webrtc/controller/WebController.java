package com.wangdm.tutorial.webrtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping("/")
    public String index(){
       
        return "index";
    }

    @RequestMapping("/textchat")
    public String textChat(){
       
        return "textchat";
    }

    @RequestMapping("/videochat")
    public String videoChat(){
       
        return "videochat";
    }
}
