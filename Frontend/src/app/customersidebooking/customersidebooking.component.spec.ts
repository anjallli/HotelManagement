import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersidebookingComponent } from './customersidebooking.component';

describe('CustomersidebookingComponent', () => {
  let component: CustomersidebookingComponent;
  let fixture: ComponentFixture<CustomersidebookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersidebookingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomersidebookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
