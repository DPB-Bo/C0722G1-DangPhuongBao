import {Component, OnInit} from '@angular/core';
import {Product} from '../product/product';
import {StackProduct} from './stack-product';
import {StackproductService} from './stackproduct.service';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-stackproduct',
  templateUrl: './stackproduct.component.html',
  styleUrls: ['./stackproduct.component.css']
})
export class StackproductComponent implements OnInit {
  productList: Product[] = [];
  stackProductList: StackProduct[] = [];
  searchName: string = '';
  tempDelete: StackProduct = {
    id: -1,
    code: 'temp',
    product: {
      'id': -1,
      'name': 'temp',
      'price': -1,
      'value': 'temp',
      'producer': 'temp'
    }
  };
  page: number = 1;
  selectProduct: Product = {
    id: -1,
    name: '--Select--'
  };
  searchDate: string = '';
  stackProductUnit = this.fb.group({
    id: [''],
    code: ['', [Validators.required, Validators.pattern(/LH-\d{4}/)]],
    product: [this.selectProduct, [Validators.required]],
    amount: ['', [Validators.min(1)]],
    dateIn: ['', [Validators.required]],
    dateProcess: ['', [Validators.required]],
    dateOutDate: ['', [Validators.required]],
  });
  submitTimes: number = 0;

  compareProduct(product1: Product, product2: Product) {
    return product1.id === product2.id;
  };

  constructor(private stackProductService: StackproductService, private fb: FormBuilder) {
    this.reload();
    this.stackProductService.getAllProduct().subscribe(data => {
      this.productList = data;
      this.productList.push(this.selectProduct);
    });
  }

  ngOnInit(): void {
  }

  add() {
    if (this.stackProductUnit.valid) {
      this.submitTimes = 0;
      this.stackProductService.saveStackProduct(this.stackProductUnit.value).subscribe(data => {
        this.reload();
      });
    } else {
      this.stackProductUnit.markAllAsTouched();
      this.submitTimes++;
    }
  }

  reload() {
    console.log(this.searchDate);
    this.stackProductService.getAllStackProduct(this.searchName, this.searchDate).subscribe(data => {
      this.stackProductList = data;
    });
  }

  deleteProduct() {
    if (this.tempDelete.id !== undefined) {
      this.stackProductService.deleteStackProduct(this.tempDelete.id).subscribe(data => {
        this.reload();
      });
    }
  }
}
