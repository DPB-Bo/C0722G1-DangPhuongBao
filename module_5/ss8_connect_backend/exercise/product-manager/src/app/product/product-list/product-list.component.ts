import {Component, OnInit} from '@angular/core';
import {IProduct} from '../../model/i-product';
import {ProductService} from '../../service/product.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: IProduct[] = [];
  temp: IProduct = {};

  constructor(private productService: ProductService, private router: Router) {
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(products => {
      console.log(this.products);
      this.products = products;
    });
  }

  // tslint:disable-next-line:typedef
  sendId(id: any) {
    return this.productService.findById(id).subscribe(data => {
      return this.temp = data;
    });
  }

  deleteProduct(): void {
    console.log(this.temp.id);
    this.productService.deleteById(this.temp.id).subscribe(data => {
      console.log(data);
      alert('Delete Thành Công!!!');
      this.ngOnInit();
    }, error => {

    }, () => {
    });
  }
}
