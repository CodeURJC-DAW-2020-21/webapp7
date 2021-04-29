import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';

@Component({
  template: `
    <!--DELETE COURSE--><div class="form-group">
      <label class="label" >Borrar curso</label>
      <form action="/admin/course/delete" method="get" enctype="multipart/form-data">

        <div class="form-group">
          <input  [(ngModel)]="course.category" type="text" class="form-control"/>
        </div>

        <input type="submit" value="Borrar" class="btn py-3 px-4 btn-primary">
      </form>
    </div>`,
  selector: 'app-courseDetails',
  styleUrls: ['../../../assets/css/style.css']
})

export class CourseDetailsComponent {
  course: Course;
  newCourse: boolean;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private courseService: CourseService,
    httpClient: HttpClient) {

    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      courseService.getCourse(id).subscribe(
        course => course = course,
        error => console.error(error)
      );
      this.newCourse = false;
    } else {
      this.course = { category: '', ageStart: 0, ageEnd:0, instructor:'',price:0 };
      this.newCourse = true;
    }
  }

  removeCourse() {
    const okResponse = window.confirm('Do you want to remove this course?');
    if (okResponse) {
      this.courseService.removeCourse(this.course).subscribe(
        _ => this.router.navigate(['/courses']),
        error => console.error(error)
      );
    }
  }

}

