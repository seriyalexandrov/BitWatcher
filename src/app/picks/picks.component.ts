import {PicksService} from "./picks.service";
import {Component, OnInit} from "@angular/core";
import {PickEntity} from "./picks.entity";

@Component({
  moduleId: module.id,
  templateUrl: "picks.component.html",
  styleUrls: ["../app.component.css"],
  providers: [PicksService]
})

export class PicksComponent implements OnInit{
  picks: PickEntity[];
  objectKeys = Object.keys;
  cryptos: any;
  url1:string = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=";
  url2:string = "&tsyms=USD";


  constructor(private picksService: PicksService) {
    //picksService.getPicksById().subscribe();
  }
  getPicksById(id: number): void {
    this.picksService.getPicksById(id)
      .subscribe(resultArray => this.picks = resultArray,
        error => console.log("Error :: " + error))
  }

  deletePick(id: number) {
    this.picksService.deletePick(id).subscribe(
      action => this.updateContent(id)
    );
  }

  updateContent(id:number): void {
    this.picks = this.picks.filter(function (pick) {
      return pick.pickId != id;
    })

  }
  ngOnInit(): void {
    this.getPicksById(1);
    var i = 0;
    var str: string = "";
    for (i = 0; i < this.picks.length; i++) {
      if(i != this.picks.length-1)
      this.picksService.getCurrency(this.picks[i].currencyId).map(cur => str += cur.name+",");
      else{
        this.picksService.getCurrency(this.picks[i].currencyId).map(cur => str += cur.name);
      }
    }
    this.picksService.getPrices(this.url1+str+this.url2)
      .subscribe(res => {
        this.cryptos = res;
        //console.log(res);
      });

  }
}
