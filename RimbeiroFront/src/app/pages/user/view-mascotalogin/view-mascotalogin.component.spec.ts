import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMascotaloginComponent } from './view-mascotalogin.component';

describe('ViewMascotaloginComponent', () => {
  let component: ViewMascotaloginComponent;
  let fixture: ComponentFixture<ViewMascotaloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMascotaloginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMascotaloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
