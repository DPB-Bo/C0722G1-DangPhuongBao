import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IRatingUnit} from '../irating-unit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  @Output() barSend:EventEmitter<IRatingUnit>;
  @Input() barGet:IRatingUnit;
  constructor() {}

  ngOnInit(): void {}


  sendRating(value:number,name:string){
    this.barSend.emit({value:value,name:name});
  }
}
