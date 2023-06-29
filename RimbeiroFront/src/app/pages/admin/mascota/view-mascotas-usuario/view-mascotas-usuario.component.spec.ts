import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMascotasUsuarioComponent } from './view-mascotas-usuario.component';

describe('ViewMascotasUsuarioComponent', () => {
  let component: ViewMascotasUsuarioComponent;
  let fixture: ComponentFixture<ViewMascotasUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMascotasUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMascotasUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
