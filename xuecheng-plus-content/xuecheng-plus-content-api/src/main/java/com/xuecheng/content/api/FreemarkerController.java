package com.xuecheng.content.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname FreemarkerController
 * @Description TODO
 * @Date 2024/9/10 20:35
 * @Created by cwl
 */
@Controller
public class FreemarkerController {

    @GetMapping("/testfreemarker")
    public ModelAndView  testfreemarker(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","文千喜");
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
