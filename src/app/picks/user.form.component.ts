import {Component, OnInit} from '@angular/core';
import {UserEntity} from "./user.entity";
import { User }    from './user';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user-form',
  templateUrl: "user.form.component.html",
  styleUrls: ['../app.component.css']
})
export class UserFormComponent implements OnInit{
  constructor(private http: HttpClient) {}
  private usersUrl = "http://localhost:8080/api/users";
  model = new UserEntity();
 // model = new User();


  onSubmit() { this.http.post(this.usersUrl+"/add", {
    name: this.model.name,
    lastname: this.model.lastname,
    userId: 0,
    login: this.model.login,
    password: this.model.password,
    email: this.model.email
  })
    .subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.log("Error occured");
      }
    );}
ngOnInit() {}


}
