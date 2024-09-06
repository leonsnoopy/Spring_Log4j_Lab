package com.gss.demo.controller;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class log4jController {
    private Logger log = LogManager.getLogger(log4jController.class);

    @PostMapping("/login")
    public String login(@RequestBody Map req) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");;
        String user = req.get("user").toString();
        String password = req.get("password").toString();

        log.error("user:{},password:{}", user, password);

        return "login";
    }
}
