package com.mainapp.mainapp.Controller;

import com.mainapp.mainapp.Entity.RequestObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getHome(){
        return "Home Page";
    }
    @PostMapping("/addUser")
    public ResponseEntity<RequestObj> addUser(@RequestBody RequestObj user){
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @GetMapping("/home")
    public String getH(@RequestBody RequestObj user){
        return "dhanshree mam";
    }
}
