import {ValidatorFn, AbstractControl, ValidationErrors} from '@angular/forms';

export class Test {
  static notMatchPassword(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      console.log('1');
      let password = control.get('password');
      let rePassword = control.get('rePassword');
      return password?.value === rePassword?.value ? null : {notMatchPassword: true};
    };
  }
}

export function notMatchPassword(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    console.log('1');
    let password = control.get('password');
    let rePassword = control.get('rePassword');
    return password?.value === rePassword?.value ? null : {notMatchPassword: true};
  };
}
