import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVeterinariosComponent } from './view-veterinarios.component';

describe('ViewVeterinariosComponent', () => {
  let component: ViewVeterinariosComponent;
  let fixture: ComponentFixture<ViewVeterinariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewVeterinariosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewVeterinariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
