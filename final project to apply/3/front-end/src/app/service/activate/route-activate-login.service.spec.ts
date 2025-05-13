import { TestBed } from '@angular/core/testing';

import { RouteActivateLoginService } from './route-activate-login.service';

describe('RouteActivateLoginService', () => {
  let service: RouteActivateLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteActivateLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
