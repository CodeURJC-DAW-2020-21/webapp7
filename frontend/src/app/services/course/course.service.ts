import { Injectable, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import {Course} from '../../models/Course/course.model';

const BASE_URL =  '/api/courses/';

@Injectable({
  providedIn: 'root'
})
export class CourseService implements OnInit{
  courses: Course[] = [];
  course: Course;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getCoursesList();
  }

  // tslint:disable-next-line:typedef
  addCourse(course: Course){

      return this.http.post(BASE_URL, course, {withCredentials:true})
        .pipe(
          catchError(error => this.handleError(error))
        );

  }

  getCoursesList() {
    this.http.get<any>(BASE_URL).subscribe(
      response => {
        let data: any = response;
        for (var i = 0; i < data.length; i++) {
          let newCourse = data[i];
          this.courses.push(newCourse);
        }
      }
    );
  }
  getCourse(category: string) {
    this.http.get<any>(BASE_URL + category).subscribe(
      response => {
        this.course = response;
      }
    );
  }

  public getCourses(): Observable<Course[]> {
    return this.http.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course[]>;
  }

  // tslint:disable-next-line:typedef
  deleteCourse(id: number) {
    return this.http.delete(BASE_URL + id, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ).subscribe(response => {
      const data: any = response; } );
  }

  // tslint:disable-next-line:typedef

  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

  postImage (course: Course, form: FormData) {
    const ROUTE = BASE_URL + course.id + '/image';
    console.log(ROUTE);
    return this.http.post(ROUTE, form, {withCredentials:true})
      .pipe(
        catchError(error => this.handleError(error))
      );
  }
}
