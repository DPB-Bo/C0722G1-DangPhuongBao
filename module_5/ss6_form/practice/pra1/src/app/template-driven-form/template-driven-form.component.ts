import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Iitem} from '../iitem';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {
  @Output() tempItem:EventEmitter<Iitem>=new EventEmitter();
  itemSend:Iitem={};
  constructor() {}

  ngOnInit(): void {}

  add(value: Iitem){
    this.tempItem.emit(value);
  }
}
