import {Injectable, OnInit} from '@angular/core';
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
export class CourseService implements OnInit{
  courses: Course[] = [];
  course: Course;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getCoursesList();
  }

  // tslint:disable-next-line:typedef
  addCourse(category: string, ageStart: number,ageEnd: number, instructor: string, price: number): Observable<Course>{
    return this.http.post(BASE_URL, {category,ageStart, ageEnd, instructor, price}, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course>;
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
  postImage (idCourse: number, form: FormData){

    return this.http.post(BASE_URL + idCourse + '/image', form).pipe(
      catchError(error => this.handleError(error))
    );

  }
}
