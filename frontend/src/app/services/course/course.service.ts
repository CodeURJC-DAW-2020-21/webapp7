import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import {Course} from '../../models/Course/course.model';

const BASE_URL = environment.apiBase + '/courses/';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  createCourse(courseData: FormData){
    return this.http.post(BASE_URL, courseData).pipe(
      catchError(error => this.handleError(error))
    );
  }
  // tslint:disable-next-line:typedef
  public getCourse(id: number | string): Observable<Course> {
    const url = BASE_URL + id;
    return this.http.get(url).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course>;
  }

  public getCourses(): Observable<Course[]> {
    return this.http.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course[]>;
  }
  /*getCourseById(id: number): Observable<Course>{
    return this.httpClient.get(BASE_URL + id).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course>;
  }

   */

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

}
