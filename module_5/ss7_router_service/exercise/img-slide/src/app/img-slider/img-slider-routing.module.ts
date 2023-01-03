import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import * as path from 'path';
import {ImgSlideComponent} from './img-slide/img-slide.component';
import {ImgListComponent} from './img-list/img-list.component';
import {ImgSliderComponent} from './img-slider.component';

const routes: Routes = [
  {path:'slider',component:ImgSliderComponent,children:[
      {path:'slide',component:ImgSlideComponent},
      {path:'list',component:ImgListComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImgSliderRoutingModule { }
