import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../product/product';
import {StackProduct} from './stack-product';

@Injectable({
  providedIn: 'root'
})
export class StackproductService {
  URL_PRODUCT = 'http://localhost:3000/product';
  URL_STACK_PRODUCT = 'http://localhost:3000/stackProduct';

  constructor(private client: HttpClient) {
  }

  getAllProduct() {
    return this.client.get<Product[]>(this.URL_PRODUCT);
  }

  getAllStackProduct(searchName: string, searchDateOutDate: string) {
    return this.client.get<StackProduct[]>(this.URL_STACK_PRODUCT + '?product.name_like=' + searchName + '&dateOutDate_like=' + searchDateOutDate);
  }

  saveStackProduct(stackProduct: StackProduct) {
    return this.client.post<StackProduct>(this.URL_STACK_PRODUCT, stackProduct);
  }

  deleteStackProduct(stackProductId: number) {
    return this.client.delete<StackProduct>(this.URL_STACK_PRODUCT + '/' + stackProductId);
  }
}
