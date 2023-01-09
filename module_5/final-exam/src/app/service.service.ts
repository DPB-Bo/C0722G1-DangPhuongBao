import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  URL: string = 'http://localhost:3000'
  constructor() { }
}
