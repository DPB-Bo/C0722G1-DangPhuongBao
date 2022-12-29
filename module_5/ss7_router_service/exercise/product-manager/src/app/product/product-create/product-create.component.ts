import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Product} from '../product';
import {ProductServiceService} from '../product-service.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm = this.fb.group({
    id:[''],
    name: [''],
    price:[''],
    description: ['']
  })
  constructor(private fb:FormBuilder,private productService:ProductServiceService) { }

  ngOnInit(): void {
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product);
    this.productForm.reset();
  }
}
