import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Validators} from '@angular/forms';
import {FormArray} from '@angular/forms';

@Component({
  selector: 'app-reactive-form-prac',
  templateUrl: './reactive-form-prac.component.html',
  styleUrls: ['./reactive-form-prac.component.css']
})
export class ReactiveFormPracComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }

}
