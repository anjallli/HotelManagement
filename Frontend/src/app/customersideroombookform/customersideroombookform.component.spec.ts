import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomersideroombookformComponent } from './customersideroombookform.component';

describe('CustomersideroombookformComponent', () => {
  let component: CustomersideroombookformComponent;
  let fixture: ComponentFixture<CustomersideroombookformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomersideroombookformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomersideroombookformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
