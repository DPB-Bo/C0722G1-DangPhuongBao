import {Country} from './country';

export interface UserUnit {
  email?: string;
  password?: string;
  re_password?: string;
  country?: Country;
  age?: number;
  gender?:boolean;
  phone?:string;
}
