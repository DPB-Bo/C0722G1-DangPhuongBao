import {Component, OnInit} from '@angular/core';
import {IWord} from "../iword";
import {DictonaryServiceService} from "../dictonary-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dictonary-page-component',
  templateUrl: './dictonary-page-component.component.html',
  styleUrls: ['./dictonary-page-component.component.css']
})
export class DictonaryPageComponentComponent implements OnInit {
  iWordList: IWord[];

  constructor(private dService: DictonaryServiceService, private router: Router) {
    this.iWordList = dService.getIWordList();
  }

  ngOnInit(): void {
  }

  showDetail(word: string) {
    this.router.navigate(['detail', word]);
  }
}
