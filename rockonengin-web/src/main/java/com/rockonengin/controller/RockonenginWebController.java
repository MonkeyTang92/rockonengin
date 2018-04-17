package com.rockonengin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangfan on 2018/3/18.
 */
@Controller
public class RockonenginWebController {

    @RequestMapping("/index")
    public String toIndex(){
        return "rockonengin/index";
    }


}
