import {Component, OnInit} from '@angular/core';
import {IRatingUnit} from '../irating-unit';

@Component({
  selector: 'app-bar-list',
  templateUrl: './bar-list.component.html',
  styleUrls: ['./bar-list.component.css']
})
export class BarListComponent implements OnInit {
   bar1:IRatingUnit={
    name:'bar1', value:1
  }
   bar2:IRatingUnit={
    name:'bar2', value:2
  }
   bar3:IRatingUnit={
    name:'bar3', value:3
  }
   bar4:IRatingUnit={
    name:'bar4', value:4
  }
  barList:IRatingUnit[] =[this.bar1,this.bar2,this.bar3,this.bar4]
  constructor() {}

  changeRating(iRating:IRatingUnit){
    for (let iRatingTempIndex in this.barList) {
      if (iRating.name==this.barList[iRatingTempIndex].name){
        this.barList[iRatingTempIndex]=iRating;
      }
    }
  }
  ngOnInit(): void {}

}
