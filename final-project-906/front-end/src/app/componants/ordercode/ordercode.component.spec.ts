import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdercodeComponent } from './ordercode.component';

describe('OrdercodeComponent', () => {
  let component: OrdercodeComponent;
  let fixture: ComponentFixture<OrdercodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdercodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdercodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
