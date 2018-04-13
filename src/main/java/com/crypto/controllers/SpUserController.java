package com.crypto.controllers;

import com.crypto.entities.DBUser;
import com.crypto.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


  @RestController
  @RequestMapping("/api/users")
  public class SpUserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
      userRepository.delete(id);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/getAll")
    public List<DBUser> getAll(){
      return userRepository.findAll();
    }


    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity add(DBUser newUser){
      userRepository.save(newUser);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @RequestMapping("/find/{id}")
    public DBUser find(@PathVariable Integer id){
      return userRepository.findOne(id);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity edit(DBUser userToBeChanged){
      userRepository.save(userToBeChanged);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/addList",method = RequestMethod.PUT)
    public ResponseEntity addList(List<DBUser> users){
      userRepository.save(users);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
  }




