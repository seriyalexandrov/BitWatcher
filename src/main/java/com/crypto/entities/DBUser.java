package com.crypto.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users", schema = "public", catalog = "crypto")
public class DBUser {
  private String name;
  private String lastname;
  private int userId;
  private String login;
  private String password;
  private String email;
  private Set<DBPicked> picks;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
  public Set<DBPicked> getPicks(){
    return picks;
  }
  public void setPicks(Set<DBPicked> currencies){
    this.picks = currencies;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 80)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "lastname", nullable = false, length = 80)
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @Id
  @GeneratedValue(generator="seqGen3")
  @SequenceGenerator(name="seqGen3",sequenceName="users_seq_id", allocationSize=1)
  @Column(name = "user_id", nullable = false)
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "login", nullable = false, length = 80)
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  @Basic
  @Column(name = "password", nullable = false, length = 80)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Basic
  @Column(name = "email", nullable = true, length = 80)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    DBUser dbUser = (DBUser) o;

    if (userId != dbUser.userId) return false;
    if (name != null ? !name.equals(dbUser.name) : dbUser.name != null) return false;
    if (lastname != null ? !lastname.equals(dbUser.lastname) : dbUser.lastname != null) return false;
    if (login != null ? !login.equals(dbUser.login) : dbUser.login != null) return false;
    if (password != null ? !password.equals(dbUser.password) : dbUser.password != null) return false;
    if (email != null ? !email.equals(dbUser.email) : dbUser.email != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + userId;
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
