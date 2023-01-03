import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ImgSliderRoutingModule } from './img-slider-routing.module';
import { ImgSlideComponent } from './img-slide/img-slide.component';
import { ImgListComponent } from './img-list/img-list.component';
import {ImgSliderComponent} from './img-slider.component';


@NgModule({
  declarations: [ImgSliderComponent, ImgSlideComponent, ImgListComponent],
  imports: [
    CommonModule,
    ImgSliderRoutingModule
  ]
})
export class ImgSliderModule { }
