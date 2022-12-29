import {Component, OnInit} from '@angular/core';
import {IWord} from "../iword";
import {ActivatedRoute} from "@angular/router";
import {DictonaryServiceService} from "../dictonary-service.service";

@Component({
  selector: 'app-dictonary-detail-component',
  templateUrl: './dictonary-detail-component.component.html',
  styleUrls: ['./dictonary-detail-component.component.css']
})
export class DictonaryDetailComponentComponent implements OnInit {
  iWord: IWord | null;

  constructor(private activatedRoute: ActivatedRoute,
              private dService: DictonaryServiceService) {
    this.activatedRoute.paramMap.subscribe(data => {
        let word = data.get('word');
        if (word !== null) {
          this.iWord = dService.findByWord(word);
        }
      }, error => {
      },
      () => {
      }
    )
  }

  ngOnInit(): void {
  }

}
