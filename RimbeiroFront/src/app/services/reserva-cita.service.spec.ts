import { TestBed } from '@angular/core/testing';

import { ReservaCitaService } from './reserva-cita.service';

describe('ReservaCitaService', () => {
  let service: ReservaCitaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReservaCitaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
