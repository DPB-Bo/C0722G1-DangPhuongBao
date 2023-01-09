import {Product} from '../product/product';

export interface StackProduct {
  id?: number;
  code?: string;
  product?: Product;
  amount?: number;
  dateIn?: Date;
  dateProcess?: Date;
  dateOutDate?: Date;
}
