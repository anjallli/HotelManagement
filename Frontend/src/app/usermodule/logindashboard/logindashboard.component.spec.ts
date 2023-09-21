import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogindashboardComponent } from './logindashboard.component';

describe('LogindashboardComponent', () => {
  let component: LogindashboardComponent;
  let fixture: ComponentFixture<LogindashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogindashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogindashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
