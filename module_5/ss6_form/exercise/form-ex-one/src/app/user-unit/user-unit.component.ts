import {Component, OnInit} from '@angular/core';
import {Validators, FormGroup, FormControl, FormBuilder, EmailValidator} from '@angular/forms';
import {Country} from '../country';
import {checkValidPhone} from '../validation/phone-validation';
import {UserUnit} from '../user-unit';
import {notMatchPassword, Test} from '../validation/not-match-password';

@Component({
  selector: 'app-user-unit',
  templateUrl: './user-unit.component.html',
  styleUrls: ['./user-unit.component.css']
})
export class UserUnitComponent implements OnInit {
  country1: Country = {
    id: 1,
    name: 'Country1'
  };
  country2: Country = {
    id: 2,
    name: 'Country2'
  };
  country3: Country = {
    id: 3,
    name: 'Country3'
  };
  countryList: Country[] = [this.country1, this.country2, this.country3];
  userUnit = this.fb.group({
    email: ['', [
      Validators.required,
      Validators.email
    ]],
    password: ['', [Validators.maxLength(6), Validators.required]],
    rePassword: ['', [Validators.maxLength(6), Validators.required]],

    country: ({
      id: [''],
      name: [''],
    })
    ,
    age: [[Validators.min(18), Validators.required]],
    gender: [Validators.required],
    phone: ['', [
      Validators.required,
      checkValidPhone(/^\+84\d{9,10}$/)
    ]]
  }, {validators: notMatchPassword()});

  userDetails: UserUnit = {};

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
  }

  checkDate() {
    this.userDetails = this.userUnit.value;
    console.log(this.userUnit);

  }

  compareFn(c1: Country, c2: Country): boolean {
    return c1.id === c2.id;
  }
}
