import { Component } from '@angular/core';
import {DataService} from "./data.service";

@Component({
  moduleId: module.id,
  selector: 'app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  // objectKeys = Object.keys;
  // cryptos: any;
  //
  // constructor(private _data: DataService) {
  //
  // }

  // ngOnInit() {
  //   this._data.getPrices()
  //     .subscribe(res => {
  //       this.cryptos = res;
  //       console.log(res);
  //     });
  // }

}
