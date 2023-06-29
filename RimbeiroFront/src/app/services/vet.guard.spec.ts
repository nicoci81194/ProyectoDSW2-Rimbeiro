import { TestBed } from '@angular/core/testing';

import { VetGuard } from './vet.guard';

describe('VetGuard', () => {
  let guard: VetGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(VetGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
