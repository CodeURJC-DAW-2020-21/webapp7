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

  constructor(private router: Router, public service: CourseService, activatedRoute: ActivatedRoute) {
    const id = activatedRoute.snapshot.params['id'];
    service.getCourse(id).subscribe(
      course => this.course = course,
      error => console.error(error)
    );
  }

  ngOnInit(): void {
  }

}
