// @ts-ignore
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserStudentComponent } from './user-student.component';

describe('FooterComponent', () => {
  let component: UserStudentComponent;
  let fixture: ComponentFixture<UserStudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserStudentComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
