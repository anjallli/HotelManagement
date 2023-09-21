import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerSidePaymentComponent } from './customer-side-payment.component';

describe('CustomerSidePaymentComponent', () => {
  let component: CustomerSidePaymentComponent;
  let fixture: ComponentFixture<CustomerSidePaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerSidePaymentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerSidePaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
