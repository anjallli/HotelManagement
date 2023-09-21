import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersideAddcustomerComponent } from './customerside-addcustomer.component';

describe('CustomersideAddcustomerComponent', () => {
  let component: CustomersideAddcustomerComponent;
  let fixture: ComponentFixture<CustomersideAddcustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersideAddcustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomersideAddcustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
