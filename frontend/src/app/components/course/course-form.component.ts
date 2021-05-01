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
    httpClient: HttpClient) {}

  createCourse(event: any, category: string, ageStart: string, ageEnd: string, instructor: string, price: string){
    event.preventDefault();
    const start = Number(ageStart);
    const end = Number(ageEnd);
    const pr = Number(price);
    this.courseService.addCourse(category, start, end, instructor, pr).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }

}
