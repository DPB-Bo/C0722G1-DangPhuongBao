import {Injectable} from '@angular/core';
import {IWord} from "./iword";

@Injectable({
  providedIn: 'root'
})
export class DictonaryServiceService {

  constructor() {
  }

  iWordList: IWord[] = [
    {word: 'táo', mean: 'apple'},
    {word: 'chuối', mean: 'banana'},
    {word: 'candy', mean: 'kẹo'},
    {word: 'kẹo', mean: 'candy'},
    {word: 'angular', mean: 'front-end'},
    {word: 'front-end', mean: 'angular'},
    {word: 'Bảo', mean: 'ADMIN'},
  ];

  getIWordList() {
    return this.iWordList;
  }

  findByWord(word: string) {
    let iWord = this.iWordList.filter(iWord => iWord.word === word);
    if (iWord.length <= 0) {
      return null;
    }
    return iWord[0];
  }

}
