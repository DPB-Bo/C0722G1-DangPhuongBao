import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {NavigationComponent} from './navigation/navigation.component';
import {FacilityListComponent} from './facility/facility-list/facility-list.component';
import {FacilityEditComponent} from './facility/facility-edit/facility-edit.component';
import {FacilitySaveComponent} from './facility/facility-save/facility-save.component';
import {CustomerListComponent} from './customer/customer-list/customer-list.component';
import {CustomerEditComponent} from './customer/customer-edit/customer-edit.component';
import {CustomerSaveComponent} from './customer/customer-save/customer-save.component';
import {ContractListComponent} from './contract/contract-list/contract-list.component';
import {ContractSaveComponent} from './contract/contract-save/contract-save.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavigationComponent,
    FacilityListComponent,
    FacilityEditComponent,
    FacilitySaveComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerSaveComponent,
    ContractListComponent,
    ContractSaveComponent
  ],
  imports: [
    BrowserModule,
    MatSlideToggleModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
