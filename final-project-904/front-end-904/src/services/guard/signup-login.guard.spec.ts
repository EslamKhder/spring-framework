import { TestBed } from '@angular/core/testing';

import { SignupLoginGuard } from './signup-login.guard';

describe('SignupLoginGuard', () => {
  let guard: SignupLoginGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(SignupLoginGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
