import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMascotasComponent } from './view-mascotas.component';

describe('ViewMascotasComponent', () => {
  let component: ViewMascotasComponent;
  let fixture: ComponentFixture<ViewMascotasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMascotasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMascotasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
