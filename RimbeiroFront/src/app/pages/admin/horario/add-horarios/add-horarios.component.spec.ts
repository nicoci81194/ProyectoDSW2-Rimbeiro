import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHorariosComponent } from './add-horarios.component';

describe('AddHorariosComponent', () => {
  let component: AddHorariosComponent;
  let fixture: ComponentFixture<AddHorariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddHorariosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddHorariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
