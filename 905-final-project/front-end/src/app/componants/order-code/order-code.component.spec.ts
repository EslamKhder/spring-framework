import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderCodeComponent } from './order-code.component';

describe('OrderCodeComponent', () => {
  let component: OrderCodeComponent;
  let fixture: ComponentFixture<OrderCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderCodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
