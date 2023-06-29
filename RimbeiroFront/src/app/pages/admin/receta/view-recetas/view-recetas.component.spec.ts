import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRecetasComponent } from './view-recetas.component';

describe('ViewRecetasComponent', () => {
  let component: ViewRecetasComponent;
  let fixture: ComponentFixture<ViewRecetasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRecetasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRecetasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
