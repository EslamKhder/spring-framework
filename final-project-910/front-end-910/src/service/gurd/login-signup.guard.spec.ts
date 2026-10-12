import { TestBed } from '@angular/core/testing';

import { LoginSignupGuard } from './login-signup.guard';

describe('LoginSignupGuard', () => {
  let guard: LoginSignupGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoginSignupGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
