import { Component, OnInit } from '@angular/core';
import { Caculator } from '../caculator';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {
  caculator: Caculator={
    number1:'0',
    number2:'0',
    result:0
  };

  constructor() { }

  ngOnInit(): void {
  }

  getResult(s:string) {
    this.caculator.result= eval(this.caculator.number1+s+this.caculator.number2);
  }
}