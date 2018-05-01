package com.crypto.controllers;

import com.crypto.entities.DBPicked;
import com.crypto.entities.DBUser;
import com.crypto.entities.URLhack;
import com.crypto.services.PickedRepository;
import com.crypto.services.PickedService;
import com.crypto.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api/picked")
public class SpPickedController {
  @Autowired
  private PickedRepository pickedRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PickedService pickedService;


  @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
  public ResponseEntity delete(@PathVariable Integer id){
    pickedRepository.delete(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @RequestMapping("/getAll")
  public List<DBPicked> getAll(){
    return pickedRepository.findAll();
  }



  @RequestMapping(value = "/add", method = RequestMethod.PUT)
  public ResponseEntity add(DBPicked newPick){
      pickedService.add(newPick);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @RequestMapping("/getCurrenciesForUser/{id}")
  public URLhack getCurrenciesNames(@PathVariable Integer id){
    return pickedService.getCurrenciesByUser(userRepository.findOne(id));
  }

  @RequestMapping("/getCurrenciesDailyHistoryForUser/{id}")
  public List<URLhack> getCurrenciesDailyHistory(@PathVariable Integer id){
    return pickedService.getDailyHistoryByUser(userRepository.findOne(id));
  }



  @RequestMapping("/find/{id}")
  public DBPicked find(@PathVariable Integer id){
    return pickedRepository.findOne(id);
  }

  @RequestMapping("/findPicked/{id}")
  public List<DBPicked> findPicked(@PathVariable Integer id){
    return pickedRepository.findAllByUser(userRepository.findOne(id));
  }

  @RequestMapping(value = "/edit",method = RequestMethod.PUT)
  public ResponseEntity edit(DBPicked pickToBeChanged){
    pickedRepository.save(pickToBeChanged);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }

  @RequestMapping(value = "/addList",method = RequestMethod.PUT)
  public ResponseEntity addList(List<DBPicked> picks){
    pickedRepository.save(picks);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}

