import {Component, Input, OnInit} from '@angular/core';
import {Iitem} from '../iitem';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  items: Iitem[]=[
    {name: '1',num:1,dOB:'1'},
    {name: '2',num:2,dOB:'2'},
    {name: '3',num:3,dOB:'3'},
    {name: '4',num:4,dOB:'4'},
    {name: '5',num:5,dOB:'5'},
  ]
  @Input('tempItem') tempItem;
  constructor() { }

  add(tempItem: Iitem){
    this.items.push(tempItem);
  }
  ngOnInit(): void {
  }

}
