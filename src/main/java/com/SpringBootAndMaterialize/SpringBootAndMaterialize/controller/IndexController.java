package com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lucasbarros on 05/05/17.
 */

@Controller
public class IndexController {

    private static final String INDEX = "index";

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView(INDEX);
    }

}
