import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReservacitasMascotaComponent } from './view-reservacitas-mascota.component';

describe('ViewReservacitasMascotaComponent', () => {
  let component: ViewReservacitasMascotaComponent;
  let fixture: ComponentFixture<ViewReservacitasMascotaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewReservacitasMascotaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewReservacitasMascotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
