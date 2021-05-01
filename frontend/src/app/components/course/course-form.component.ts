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

  createCourse(event: any, category: string, ageStart: number, ageEnd: number, instructor:string, price:number){
    event.preventDefault();
    this.courseService.addCourse(category,ageStart, ageEnd, instructor, price).subscribe(
      response => console.log(response),
      error =>console.log(error)
    );
  }

}
