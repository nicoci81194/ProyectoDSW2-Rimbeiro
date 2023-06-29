import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVeterinariosComponent } from './add-veterinarios.component';

describe('AddVeterinariosComponent', () => {
  let component: AddVeterinariosComponent;
  let fixture: ComponentFixture<AddVeterinariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddVeterinariosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddVeterinariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
