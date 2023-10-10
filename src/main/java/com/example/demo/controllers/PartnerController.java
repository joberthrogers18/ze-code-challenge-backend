package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/test")
public class PartnerController {

    @GetMapping("")
    public Map<String, String> getTestMy() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "hello");
        return response;
    }

}
