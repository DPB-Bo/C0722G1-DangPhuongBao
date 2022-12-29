import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DictonaryDetailComponentComponent } from './dictonary-detail-component.component';

describe('DictonaryDetailComponentComponent', () => {
  let component: DictonaryDetailComponentComponent;
  let fixture: ComponentFixture<DictonaryDetailComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DictonaryDetailComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DictonaryDetailComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
