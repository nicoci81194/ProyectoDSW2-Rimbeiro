import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReservacitasComponent } from './view-reservacitas.component';

describe('ViewReservacitasComponent', () => {
  let component: ViewReservacitasComponent;
  let fixture: ComponentFixture<ViewReservacitasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewReservacitasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewReservacitasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
