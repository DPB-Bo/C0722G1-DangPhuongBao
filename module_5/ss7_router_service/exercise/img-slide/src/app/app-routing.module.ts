import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImgSliderComponent} from './img-slider/img-slider.component';



const routes: Routes = [
  {path:'slider',component:ImgSliderComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
