import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMascotasComponent } from './add-mascotas.component';

describe('AddMascotasComponent', () => {
  let component: AddMascotasComponent;
  let fixture: ComponentFixture<AddMascotasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMascotasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddMascotasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
