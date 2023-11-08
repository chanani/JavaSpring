package com.chanhan.ex05;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.lang.annotation.Annotation;

public class SimpleUrlController implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("컨트롤러");
        return new ModelAndView("/test/index.jsp");
    }
}
