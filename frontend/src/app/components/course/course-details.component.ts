import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';
import {Observable} from 'rxjs';

@Component({
  template: `
    <!--DELETE COURSE--><div class="form-group">
      <label class="label" >Borrar curso</label>
      <form action="/admin/course/delete" method="get" enctype="multipart/form-data">

        <div class="form-group">
          <input  #id type="text" class="form-control"/>
        </div>

        <input type="submit" value="Crear" class="btn py-3 px-4 btn-primary"
               (click)="removeCourse($event, id.value)">
      </form>
    </div>`,
  // tslint:disable-next-line:component-selector
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
    }

  // tslint:disable-next-line:typedef
  /*  removeCourse(event: any, id: string) {
      event.preventDefault();
      const okResponse = window.confirm('Do you want to remove this course?');
      if (okResponse) {
        const stringToConvert = id;
        const numberValue = Number(stringToConvert);
        this.courseService.deleteCourse(numberValue).subscribe(
          _ => this.router.navigate(['/user-admin']),
          error => console.error(error)
        );
      }
    }*/
  removeCourse(event: any, id: string) {
    event.preventDefault();
    const okResponse = window.confirm('Do you want to remove this course?');
    if (okResponse) {
      let list = this.courseService.courses;
      for (let i = 0; i < list.length; i++){
        if (list[i].category === id){
          this.courseService.deleteCourse(this.courseService.courses[i].id);
        }
      }
    }
  }


}

