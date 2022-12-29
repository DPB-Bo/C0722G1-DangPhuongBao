import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictonaryPageComponentComponent} from "./Dictonary/dictonary-page-component/dictonary-page-component.component";
import {
  DictonaryDetailComponentComponent
} from "./Dictonary/dictonary-detail-component/dictonary-detail-component.component";


const routes: Routes = [
  {path:'',component:DictonaryPageComponentComponent},
  {path:'detail/:word',component:DictonaryDetailComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
