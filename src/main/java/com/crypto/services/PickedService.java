package com.crypto.services;

import com.crypto.entities.DBPicked;
import com.crypto.entities.DBUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PickedService{
  private PickedRepository pickedRepository;

  @Autowired
  public void setPickedRepository(PickedRepository pickedRepository){
    this.pickedRepository = pickedRepository;
  }

  public void add(DBPicked newPick){
    boolean isContain = false;
    List<DBPicked> arr = pickedRepository.findAllByUser(newPick.getUser());
    for(int i = 0; i < arr.size();i++){
      if(arr.get(i).getCurrency().getCurrencyId() == newPick.getCurrency().getCurrencyId()){
        isContain = true;
      }
    }
    if(!isContain) {
      pickedRepository.save(newPick);
    }
  }

  public String getNamesOfCurrenciesByUser(DBUser user){
    String names = "";
    List<DBPicked> arr = pickedRepository.findAllByUser(user);
    for(int i = 0; i < arr.size();i++){
      if(i == arr.size()-1){
        names += arr.get(i).getCurrency().getName();
        continue;
      }
        names += arr.get(i).getCurrency().getName() + ",";
      }
      return names;
  }

}
