import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { DictonaryPageComponentComponent } from './Dictonary/dictonary-page-component/dictonary-page-component.component';
import { DictonaryDetailComponentComponent } from './Dictonary/dictonary-detail-component/dictonary-detail-component.component';
import {AppRoutingModule} from "./app-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    DictonaryPageComponentComponent,
    DictonaryDetailComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
