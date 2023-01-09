import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StackproductComponent } from './stackproduct.component';

describe('StackproductComponent', () => {
  let component: StackproductComponent;
  let fixture: ComponentFixture<StackproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StackproductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StackproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
