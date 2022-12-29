import {Component, Input, OnInit, SimpleChanges} from '@angular/core';
import {Product} from '../product';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductServiceService} from '../product-service.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  @Input() product: Product={};

  productForm:FormGroup;
  constructor(private fb:FormBuilder,private productService:ProductServiceService) {}

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges){
    this.productForm= this.fb.group({
      id:[this.product.id],
      name: [this.product.name],
      price:[this.product.price],
      description: [this.product.description]
    })
  }
  submit() {
    const product = this.productForm.value;
    this.productService.updateProduct(product);
  }
}
