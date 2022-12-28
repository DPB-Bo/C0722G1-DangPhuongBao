import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {UserUnit} from '../user-unit';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {
  userUnit = this.fb.group({
    email: ['', [
      Validators.required,
      Validators.email
    ]],
    password: ['', [Validators.maxLength(6), Validators.required]],
    rePassword: ['', [Validators.maxLength(6), Validators.required]],

  });

  userDetails: UserUnit = {};

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {}

  checkDate() {
    this.userDetails = this.userUnit.value;
    console.log(this.userUnit);

  }

}
