import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { NavigationComponent } from './component/navigation/navigation.component';
import { FacilityListComponent } from './component/facility/facility-list/facility-list.component';
import { FacilityEditComponent } from './component/facility/facility-edit/facility-edit.component';
import { FacilitySaveComponent } from './component/facility/facility-save/facility-save.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { CustomerSaveComponent } from './component/customer/customer-save/customer-save.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';
import { ContractSaveComponent } from './component/contract/contract-save/contract-save.component';

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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
