import {Employee} from '../employee/Employee';
import {Facility} from '../facility/Facility';
import {Customer} from '../customer/customer';

export interface Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  employee?: Employee;
  customer?: Customer;
  facility?: Facility;
}
