package com.example.app.shopping.controller;

import com.example.app.shopping.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("GET / ..." + principalDetails);
        return "index";
    }

}
