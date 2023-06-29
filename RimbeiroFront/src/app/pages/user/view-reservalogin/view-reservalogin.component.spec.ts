import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReservaloginComponent } from './view-reservalogin.component';

describe('ViewReservaloginComponent', () => {
  let component: ViewReservaloginComponent;
  let fixture: ComponentFixture<ViewReservaloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewReservaloginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewReservaloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
