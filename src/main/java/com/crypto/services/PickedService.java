package com.crypto.services;

import com.crypto.entities.DBPicked;
import com.crypto.entities.DBUser;
import com.crypto.entities.URLhack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

  public URLhack getCurrenciesByUser(DBUser user){
    URLhack str = new URLhack();
    String names = "";
    List<DBPicked> arr = pickedRepository.findAllByUser(user);
    for(int i = 0; i < arr.size();i++){
      if(i == arr.size()-1){
        names += arr.get(i).getCurrency().getName();
        continue;
      }
        names += arr.get(i).getCurrency().getName() + ",";
      }
      str.setMyURL("https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + names + "&tsyms=USD");
      return str;
  }

  public List<URLhack> getDailyHistoryByUser(DBUser user){
    List<URLhack> urls = new ArrayList<>();
    List<DBPicked> arr = pickedRepository.findAllByUser(user);
    for(int i = 0; i < arr.size();i++){
      URLhack str = new URLhack();
      str.setMyURL("https://min-api.cryptocompare.com/data/histoday?fsym=" + arr.get(i).getCurrency().getName() + "&tsym=USD&limit=30&aggregate=3&e=CCCAGG");
      urls.add(str);
    }
    return urls;
  }
}
