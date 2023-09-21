import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBookingComponent } from './add-booking.component';

describe('AddBookingComponent', () => {
  let component: AddBookingComponent;
  let fixture: ComponentFixture<AddBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
