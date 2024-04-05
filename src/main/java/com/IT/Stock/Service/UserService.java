package com.IT.Stock.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IT.Stock.Model.User;
import com.IT.Stock.Repository.UserJpaRepository;

@Service
public class UserService {
    
    @Autowired
    private UserJpaRepository userJpaRepository;

    public boolean authenticate(String username, String password){
        try{
        User user = userJpaRepository.findByUsername(username);
        if(user == null){
            return false;
        
        }
        else{
            if(user.getPassword().equals(password)){
                return true;
            }
            else{
                return false;
                            }
        }
    }
    catch(NoSuchElementException e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
    
}
