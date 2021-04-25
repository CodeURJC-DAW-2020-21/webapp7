import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserInstructorComponent } from './user-instructor.component';

describe('FooterComponent', () => {
  let component: UserInstructorComponent;
  let fixture: ComponentFixture<UserInstructorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserInstructorComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserInstructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
