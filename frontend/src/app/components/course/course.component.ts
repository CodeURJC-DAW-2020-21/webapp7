import { Component, OnInit } from '@angular/core';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class CourseComponent implements OnInit {

  course: Course;
  newCourse: boolean;

  constructor(private router: Router, public service: CourseService, activatedRoute: ActivatedRoute) {
    const id = activatedRoute.snapshot.params['id'];


    if (id){
      service.getCourse(id).subscribe(
        course => this.course = course,
        error => console.error(error)
      );
      this.newCourse = false;
    } else {
      this.course = {
        category: 'Piruleta',
        ageStart: 0,
        ageEnd: 0,
        instructor: 'Don Comedia',
        price: 0
      };
      this.newCourse = true;
    }


  }

  ngOnInit(): void {
  }

}
