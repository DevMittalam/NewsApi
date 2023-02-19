package com.example.NewsApi.controller;

import com.example.NewsApi.services.FetchNews;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/news")
public class News {
       @GetMapping("/show")
      String show(){
          return "Hello Rahul";
      }
      @GetMapping("title")
      public ArrayList<String> arr(){
          FetchNews f=new FetchNews();
          return f.ftechApi();
      }
}
