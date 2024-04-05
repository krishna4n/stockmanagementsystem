package com.IT.Stock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IT.Stock.Model.User;
import com.IT.Stock.Service.JwtUtil;
import com.IT.Stock.Service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public ResponseEntity<?>  authenticateUser(@RequestBody User user){
        boolean isAuthenticated = userService.authenticate(user.getUsername(), user.getPassword());

        if(isAuthenticated){
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }
        else{
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
