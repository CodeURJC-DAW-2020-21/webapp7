import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import {Course} from '../../models/Course/course.model';
import {User} from '../../models/User/user.model';

const BASE_URL =  '/api/courses/';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  addCourse(course: Course){
    return this.http.post(BASE_URL, course, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    );
  }

  public getCourses(): Observable<Course[]> {
    return this.http.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course[]>;
  }

  // tslint:disable-next-line:typedef
  deleteCourse(course: Course) {
    return this.http.delete(BASE_URL + course.id, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    );
  }
/*
  public downloadImage(): Observable<Blob> {
    return this.http.get('/api/courses', responseType, 'blob') as unknown as Observable<Blob>;
  }

 */

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

}
