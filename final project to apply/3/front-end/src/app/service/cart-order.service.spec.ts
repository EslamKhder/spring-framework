import { TestBed } from '@angular/core/testing';

import { CartOrderService } from './cart-order.service';

describe('CartOrderService', () => {
  let service: CartOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
