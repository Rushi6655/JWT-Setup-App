package com.mainapp.mainapp.Controller;

import com.mainapp.mainapp.Entity.AuthRequest;
import com.mainapp.mainapp.Entity.RequestObj;
import com.mainapp.mainapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to user!!";
    }

    @PostMapping("/authenticate")
    public Map<String,String> generateToken(@RequestBody AuthRequest authRequest) {
        Map<String,String> responce=new HashMap<>();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
            responce.put("status", HttpStatus.FOUND.toString());
            responce.put("tocken",jwtUtil.generateToken(authRequest.getUserName()));
        } catch (Exception ex) {
            responce.put("status", HttpStatus.UNAUTHORIZED.toString());
            responce.put("tocken","");
        }
        return responce;
    }
}