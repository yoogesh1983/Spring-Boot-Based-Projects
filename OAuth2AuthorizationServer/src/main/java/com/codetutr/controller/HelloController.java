package com.codetutr.controller;
 
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.codetutr.dao.SpringEmJPADaoImpl;
 
@RestController
public class HelloController {
 
	@Autowired
	private SpringEmJPADaoImpl springEmJPADao;
	
    @RequestMapping("/home")
    public ModelAndView home() {
    	System.out.println(springEmJPADao.test());
    	
        Date date = new Date();
        return new ModelAndView("hello", "dateandTIme", date);
    }
}