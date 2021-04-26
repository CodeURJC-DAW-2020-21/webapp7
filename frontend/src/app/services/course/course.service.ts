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
  public getCourse(id: number) {
    const url = environment.apiBase + '/courses/' + id;
    return this.http.get(url);
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