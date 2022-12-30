import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import {Product} from "./product";
import {Category} from "./category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  URL_PRODUCT="http://localhost:3000/Product"
  URL_CATEGORY="http://localhost:3000/Category"
  constructor(private httpClient:HttpClient) { }
  getAllProducts():Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  }
  getAllCategory():Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_CATEGORY);
  }

}
