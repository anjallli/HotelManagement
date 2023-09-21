import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerallbookingsComponent } from './customerallbookings.component';

describe('CustomerallbookingsComponent', () => {
  let component: CustomerallbookingsComponent;
  let fixture: ComponentFixture<CustomerallbookingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerallbookingsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerallbookingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
