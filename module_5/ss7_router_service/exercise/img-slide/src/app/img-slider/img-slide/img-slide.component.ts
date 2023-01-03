import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-img-slide',
  templateUrl: './img-slide.component.html',
  styleUrls: ['./img-slide.component.css']
})
export class ImgSlideComponent implements OnInit {
  item:number = 0;
  constructor() { }

  ngOnInit(): void {
  }

}
