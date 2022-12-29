import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from '../product-service.service';
import {Product} from '../product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[];
  tempProduct: Product={};
  constructor(private pService:ProductServiceService) {
    this.products=this.pService.getAll();
  }

  ngOnInit(): void {
  }

}
