import { TestBed } from '@angular/core/testing';

import { RequestOrderService } from './request-order.service';

describe('RequestOrderService', () => {
  let service: RequestOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RequestOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
