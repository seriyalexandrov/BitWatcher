import {PicksComponent} from "./picks/picks.component";
import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";

export const routes: Routes = [
  { path: 'picks', component: PicksComponent},

];


export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
