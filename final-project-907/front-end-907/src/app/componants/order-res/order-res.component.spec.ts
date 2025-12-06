import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderResComponent } from './order-res.component';

describe('OrderResComponent', () => {
  let component: OrderResComponent;
  let fixture: ComponentFixture<OrderResComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderResComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderResComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
