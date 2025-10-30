import { TestBed } from '@angular/core/testing';

import { NoauthGuard } from './noauth.guard';

describe('NoauthGuard', () => {
  let guard: NoauthGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(NoauthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
