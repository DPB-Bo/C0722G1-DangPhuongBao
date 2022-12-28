import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, Validators, ValidatorFn, AbstractControl, ValidationErrors} from '@angular/forms';
import {CustomerType} from '../customer-type';

@Component({
  selector: 'app-customer-save',
  templateUrl: './customer-save.component.html',
  styleUrls: ['./customer-save.component.css']
})
export class CustomerSaveComponent implements OnInit {
  @Output() varSendData = new EventEmitter();
  diamond: CustomerType = {
    id: 1,
    name: 'Diamond'
  };
  platinum: CustomerType = {
    id: 2,
    name: 'Platinum'
  };
  gold: CustomerType = {
    id: 3,
    name: 'Gold'
  };
  silver: CustomerType = {
    id: 4,
    name: 'Silver'
  };
  member: CustomerType = {
    id: 5,
    name: 'Member'
  };
  tempCType: CustomerType = {
    id: -1,
    name: 'Please Choose'
  };
  customerTypeList: CustomerType[] = [this.tempCType, this.diamond, this.platinum, this.gold, this.silver, this.member];
  customerUnit = this.fb.group({
    id: ['', [Validators.required, Validators.pattern(/^(KH-)(\d{9})/)]],
    customerType: [this.tempCType],
    name: ['', Validators.required],
    dateOfBirth: ['', Validators.required],
    gender: [Validators.required],
    idCard: ['', [Validators.required, Validators.pattern(/(\d{9}|\d{12})/)]],
    phoneNumber: ['', [Validators.required, Validators.pattern(/^(090|091|\(84\)\+90|\(84\)\+91)\d{7}/)]],
    email: ['', [Validators.required, Validators.email]],
    address: ['', Validators.required]
  });
  valid: boolean = false;

  submitTimes: number = 0;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
  }

  displayAndAdd() {
    this.valid = this.customerUnit.valid;
    if (this.valid) {
      this.varSendData.emit(this.customerUnit.value);
      this.submitTimes = 0;
    } else {
      this.customerUnit.markAllAsTouched();
      this.customerUnit.controls.gender.markAsPristine();
      this.customerUnit.controls.gender.markAsUntouched();
      this.submitTimes++;
    }
  }

  compareCustomerType(temp1: CustomerType, temp2: CustomerType): boolean {
    return temp1.id === temp2.id;
  }
}
