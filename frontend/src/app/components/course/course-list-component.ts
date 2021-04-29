import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/User/user.model';
import {UserService} from '../../services/user/user.service';
import {LoginService} from '../../services/login/login.services';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';

@Component({
  template: `
  <!--START COURSES LIST-->
  <div class="row">
    <div class="col-lg-12 mb-12">
      <div class="card shadow mb-4">
        <div class="card-header2 py-3">
          <h6 class="m-0 font-weight-bold" style="color: black;">CURSOS</h6>
        </div>
        <div class="card-body">
          <div class="input-group">
            <div class="input-group-append">
              <div class="card-body">
                <li *ngFor="let course of courses">
                  <a>[routerLink]="['/course', category.id]">{{course.category}}</a>
                </li>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--END COURSES LIST-->
  `,
  // tslint:disable-next-line:component-selector
  selector: 'app-courseList',
  styleUrls: ['../../../assets/css/style.css']
})

export class CourseListComponent {
  course: Course;
  courses: Course[];

  constructor(private router: Router, private courseService: CourseService, public loginService: LoginService) { }

  // tslint:disable-next-line:typedef use-lifecycle-interface
  ngOnInit() {
    this.courseService.getCourses().subscribe(
      courses => this.courses = courses,
      error => console.log(error)
    );
  }

  // tslint:disable-next-line:typedef
  newUser() {
    this.router.navigate(['/courses/new']);
  }
}

