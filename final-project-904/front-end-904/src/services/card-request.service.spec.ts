import { TestBed } from '@angular/core/testing';

import { CardRequestService } from './card-request.service';

describe('CardRequestService', () => {
  let service: CardRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
