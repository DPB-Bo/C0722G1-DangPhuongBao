import { TestBed } from '@angular/core/testing';

import { StackproductService } from './stackproduct.service';

describe('StackproductService', () => {
  let service: StackproductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StackproductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
