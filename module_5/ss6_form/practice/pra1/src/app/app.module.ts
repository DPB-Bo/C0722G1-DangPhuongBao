import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TemplateDrivenFormComponent } from './template-driven-form/template-driven-form.component';
import {FormsModule} from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms';
import { ItemListComponent } from './item-list/item-list.component';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { ReactiveFormPracComponent } from './reactive-form-prac/reactive-form-prac.component';

@NgModule({
  declarations: [
    AppComponent,
    TemplateDrivenFormComponent,
    ItemListComponent,
    ReactiveFormComponent,
    ReactiveFormPracComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
