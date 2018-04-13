package com.crypto.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "currency", schema = "public", catalog = "crypto")
public class DBCurrency {
  private String name;
  private int currencyId;
  private Set<DBPicked> picks;

  @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
  public Set<DBPicked> getPicks(){
    return picks;
  }
  public void setPicks(Set<DBPicked> picks){
    this.picks = picks;
  }





  @Basic
  @Column(name = "name", nullable = false, length = 80)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue(generator="seqGen")
  @SequenceGenerator(name="seqGen",sequenceName="currency_seq_id", allocationSize=1)
  @Column(name = "currency_id", nullable = false)
  public int getCurrencyId() {
    return currencyId;
  }

  public void setCurrencyId(int currencyId) {
    this.currencyId = currencyId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DBCurrency that = (DBCurrency) o;

    if (currencyId != that.currencyId) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + currencyId;
    return result;
  }
}
