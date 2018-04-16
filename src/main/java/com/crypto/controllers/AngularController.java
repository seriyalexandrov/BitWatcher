package com.crypto.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {


  @RequestMapping({ "/picks" })
  public String index() {
   return "forward:/index.html";
  }
}
