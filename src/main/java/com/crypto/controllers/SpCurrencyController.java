package com.crypto.controllers;


import com.crypto.entities.DBCurrency;
import com.crypto.services.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

  @RestController
  @RequestMapping("/api/currencies")
  public class SpCurrencyController {
    @Autowired
    private CurrencyRepository currencyRepository;

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
      currencyRepository.delete(id);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/getAll")
    public List<DBCurrency> getAll(){
      return currencyRepository.findAll();
    }


    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity add(DBCurrency newCurrency){
      currencyRepository.save(newCurrency);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @RequestMapping("/find/{id}")
    public DBCurrency find(@PathVariable Integer id){
      return currencyRepository.findOne(id);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity edit(DBCurrency currencyToBeChanged){
      currencyRepository.save(currencyToBeChanged);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/addList",method = RequestMethod.PUT)
    public ResponseEntity addList(List<DBCurrency> currencies){
      currencyRepository.save(currencies);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
  }


