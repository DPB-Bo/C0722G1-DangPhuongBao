import {ValidatorFn, AbstractControl, ValidationErrors} from '@angular/forms';

export function checkValidPhone(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    if (control.value == null || control.value == '') {
      return null;
    }
    return nameRe.test(control.value) ? null : {checkPhone: true};
  };
}
