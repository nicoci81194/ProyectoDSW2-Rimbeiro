import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditReservacitaComponent } from './edit-reservacita.component';

describe('EditReservacitaComponent', () => {
  let component: EditReservacitaComponent;
  let fixture: ComponentFixture<EditReservacitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditReservacitaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditReservacitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
