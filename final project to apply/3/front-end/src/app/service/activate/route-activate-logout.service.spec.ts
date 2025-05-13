import { TestBed } from '@angular/core/testing';

import { RouteActivateLogoutService } from './route-activate-logout.service';

describe('RouteActivateLogoutService', () => {
  let service: RouteActivateLogoutService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteActivateLogoutService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
