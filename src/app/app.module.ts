import { DataService } from './data.service';
import { HttpClientModule } from '@angular/common/http';
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";
import {PicksService} from "./picks/picks.service";
import {PicksComponent} from "./picks/picks.component";
import {routing} from "./app.routes";

@NgModule({
  declarations: [
    AppComponent,
    PicksComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    JsonpModule,
    routing
  ],
  providers: [
  PicksService],
  bootstrap: [AppComponent]
})
export class AppModule { }
