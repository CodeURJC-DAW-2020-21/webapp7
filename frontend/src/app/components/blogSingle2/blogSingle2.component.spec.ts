import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogSingle2Component } from './blogSingle2.component';


describe('BlogSingle2Component', () => {
  let component: BlogSingle2Component;
  let fixture: ComponentFixture<BlogSingle2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlogSingle2Component ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogSingle2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
