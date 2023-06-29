import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddReservacitaComponent } from './add-reservacita.component';

describe('AddReservacitaComponent', () => {
  let component: AddReservacitaComponent;
  let fixture: ComponentFixture<AddReservacitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddReservacitaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddReservacitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
