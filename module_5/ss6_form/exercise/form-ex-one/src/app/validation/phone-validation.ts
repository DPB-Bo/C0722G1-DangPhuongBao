import {ValidatorFn,AbstractControl,ValidationErrors} from '@angular/forms';

export function checkValidPhone(nameRe: RegExp):ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    return nameRe.test(control.value)?{value: control.value}:null;
}
}
