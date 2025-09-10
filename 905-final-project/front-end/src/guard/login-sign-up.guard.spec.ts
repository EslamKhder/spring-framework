import { TestBed } from '@angular/core/testing';

import { LoginSignUpGuard } from './login-sign-up.guard';

describe('LoginSignUpGuard', () => {
  let guard: LoginSignUpGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoginSignUpGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
