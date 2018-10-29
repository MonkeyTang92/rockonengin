package com.rockonengin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tangfan on 2017/12/3.
 */
@Controller
public class HealthContorller {

    @RequestMapping("/hs")
    @ResponseBody
    public String health(){
        return "OK";
    }
}
