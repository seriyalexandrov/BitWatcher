package com.crypto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "picked", schema = "public", catalog = "crypto")
public class DBPicked {
  private int pickId;
  private DBUser user;
  private DBCurrency currency;

 // @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  public DBUser getUser(){
    return user;
  }
  public void setUser(DBUser user){
    this.user = user;
  }

 // @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "currency_id")
  public DBCurrency getCurrency(){
    return currency;
  }
  public void setCurrency(DBCurrency currency){
    this.currency = currency;
  }


  @Id
  @GeneratedValue(generator="seqGen2")
  @SequenceGenerator(name="seqGen2",sequenceName="pick_seq_id", allocationSize=1)
  @Column(name = "pick_id", nullable = false)
  public int getPickId() {
    return pickId;
  }

  public void setPickId(int pickId) {
    this.pickId = pickId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DBPicked dbPicked = (DBPicked) o;

    if (pickId != dbPicked.pickId) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return pickId;
  }
}
