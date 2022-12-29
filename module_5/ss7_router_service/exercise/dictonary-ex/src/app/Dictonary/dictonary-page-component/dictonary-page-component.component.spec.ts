import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DictonaryPageComponentComponent } from './dictonary-page-component.component';

describe('DictonaryPageComponentComponent', () => {
  let component: DictonaryPageComponentComponent;
  let fixture: ComponentFixture<DictonaryPageComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DictonaryPageComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DictonaryPageComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
