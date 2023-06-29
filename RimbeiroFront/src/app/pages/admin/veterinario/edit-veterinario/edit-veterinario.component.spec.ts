import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditVeterinarioComponent } from './edit-veterinario.component';

describe('EditVeterinarioComponent', () => {
  let component: EditVeterinarioComponent;
  let fixture: ComponentFixture<EditVeterinarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditVeterinarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditVeterinarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
