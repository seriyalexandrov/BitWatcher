package com.crypto.controllers;

import com.crypto.entities.DBPicked;
import com.crypto.services.PickedRepository;
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
@RequestMapping("/api/picked")
public class SpPickedController {
  @Autowired
  private PickedRepository pickedRepository;
  @Autowired
  private UserRepository userRepository;

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
    boolean isContain = false;
    List<DBPicked> arr = findPicked(newPick.getUser().getUserId());
    for(int i = 0; i < arr.size();i++){
      if(arr.get(i).getCurrency().getCurrencyId() == newPick.getCurrency().getCurrencyId()){
        isContain = true;
      }
    }
    if(!isContain) {
      pickedRepository.save(newPick);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
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

