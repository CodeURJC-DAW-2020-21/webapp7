import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';

@Component({
  selector: 'app-courseForm',
  templateUrl: './course-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class CourseFormComponent {
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

  cancel() {
    window.history.back();
  }

  save() {
    this.courseService.addCourse(this.course).subscribe(
      (course: Course) => this.router.navigate(['/courses/', course.id]),
      error => alert('Error creating new course: ' + error)
    );

  }
}
