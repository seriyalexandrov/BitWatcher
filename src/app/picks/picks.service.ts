import {Observable} from "rxjs/Observable";
import {UserEntity} from "./user.entity";
import {Response} from '@angular/http';
import {Injectable} from "@angular/core";
import {PickEntity} from "./picks.entity";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {CurrencyEntity} from "./currency.entity";
import {HttpClient} from "@angular/common/http";
import {URLHackEntity} from "./urlhack.entity";


@Injectable()
export class PicksService{

  private picksUrl = "http://localhost:8080/api/picked";
  private currencyUrl = "http://localhost:8080/api/currencies";
  private usersUrl = "http://localhost:8080/api/users";
  private tempUrl = "";
  result:any;
  names:any;
  constructor(private http: HttpClient) {}


  getPicksById(id:number) : Observable<PickEntity[]> {
    this.tempUrl = this.picksUrl + "/findPicked";
    return this.http.get(`${this.tempUrl}/${id}`)
      .map((response: Response) => {
        return <UserEntity[]>response.json();
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));

  }
  deletePick(id:number)  {
    this.tempUrl = this.picksUrl + "/delete";
    return this.http.delete(`${this.tempUrl}/${id}`)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));

  }

  getCurrency(id: number): Observable<CurrencyEntity>{
    this.tempUrl = this.currencyUrl + "/find";
    return this.http.get(`${this.tempUrl}/${id}`)
      .map((response: Response) => {
        return <CurrencyEntity>response.json();
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }


  getCurrencies(id:number) : Observable<URLHackEntity> {
    this.tempUrl = this.picksUrl + "/getCurrenciesForUser";
    return this.http.get(`${this.tempUrl}/${id}`)
      .map(result => this.names = result)
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getPrices(names:string) {
    return this.http.get(names)
      .map(result => this.result = result);
  }

}
