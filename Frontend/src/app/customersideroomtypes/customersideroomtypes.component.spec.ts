import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersideroomtypesComponent } from './customersideroomtypes.component';

describe('CustomersideroomtypesComponent', () => {
  let component: CustomersideroomtypesComponent;
  let fixture: ComponentFixture<CustomersideroomtypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersideroomtypesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomersideroomtypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
