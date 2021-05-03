import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/User/user.model';
import {UserService} from '../../services/user/user.service';
import {LoginService} from '../../services/login/login.services';
import {CourseService} from '../../services/course/course.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CommentService} from '../../services/comment/comment.services';
import {Course} from '../../models/Course/course.model';

@Component({
template: `<!--START STUDENTS LIST-->
<div class="form-group">
  <label class="label" >Añadir alumno/profesor a curso</label>
  <form action="/admin/user/addcourse" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <input  #course type="text" class="form-control" placeholder="nombre del curso"/>
    </div>

    <div class="form-group">
      <input  #user type="text"class="form-control" placeholder="nombre del usuario"/>
    </div>
    <input type="submit" value="añadir" class="btn py-3 px-4 btn-primary"
           (click)="addToCourse($event, course.value, user.value)">
  </form>
</div>
<div class="form-group">
  <label class="label" >Borrar alumno/profesor a curso</label>
  <form action="/admin/user/addcourse" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <input  #courseDelete type="text" class="form-control" placeholder="nombre del curso"/>
    </div>

    <div class="form-group">
      <input  #userDelete type="text"class="form-control" placeholder="nombre del usuario"/>
    </div>
    <input type="submit" value="borrar" class="btn py-3 px-4 btn-primary"
           (click)="deleteFromCourse($event, courseDelete.value, userDelete.value)">
  </form>
</div>
<!--END STUDENTS LIST-->
`,
// tslint:disable-next-line:component-selector
selector: 'app-addToCourse',
styleUrls: ['../../../assets/css/style.css']
})

export class AdminAddToCourseComponent implements OnInit {
  course: Course;
  user: User;
  newCourse: boolean;
  form: FormGroup;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private courseService: CourseService,
    private userService: UserService,
    public fb: FormBuilder) {
  }

// tslint:disable-next-line:typedef
  addToCourse(event: any, course: string, user: string) {
    event.preventDefault();
    let users = this.userService.users;

    for (let i = 0; i < users.length; i++) {
      if (users[i].name === user) {
        this.user = users[i];
      }
    }

    let courses = this.courseService.courses;
    for (let i = 0; i < courses.length; i++) {
      if (courses[i].category === course) {
        this.course = courses[i];
      }
    }
    this.userService.addUserToCourse(this.user, this.course).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }

  deleteFromCourse(event: any, course: string, user: string) {
    event.preventDefault();
    let users = this.userService.users;

    for (let i = 0; i < users.length; i++) {
      if (users[i].name === user) {
        this.user = users[i];
      }
    }

    let courses = this.courseService.courses;
    for (let i = 0; i < courses.length; i++) {
      if (courses[i].category === course) {
        this.course = courses[i];
      }
    }
    this.userService.deleteFromCourse(this.user, this.course).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }


  ngOnInit() {
    this.userService.getUsersList();
    this.courseService.getCoursesList();
  }
}
