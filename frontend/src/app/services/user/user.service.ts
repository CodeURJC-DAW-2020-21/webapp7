import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {User} from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';


const BASE_URL = '/api/admin/users/';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnInit{
  users: User [] = [];
  user: User;

   constructor(private http: HttpClient) { }

  //cuando iniciamos app guardamos la lista de  usuarios
  ngOnInit(){
    this.getUsersList();
  }

  // tslint:disable-next-line:typedef
  addUser(user: User){

    return this.http.post(BASE_URL, user)
      .pipe(
        catchError(error => this.handleError(error))
      );

  }

  addUserToCourse(user: User, course: Course){
    return this.http.put(BASE_URL + user.id + '/course/' + course.id,{withCredentials:true}).pipe(
    );
  }
  deleteFromCourse(user: User, course: Course){
    return this.http.delete(BASE_URL + user.id + '/course/' + course.id,{withCredentials:true}).pipe(
    );
  }
  getUsersList() {
    this.http.get<any>(BASE_URL).subscribe(
      response => {
        let data: any = response;
        for (var i = 0; i < data.length; i++) {
          let newUser = data[i];
          this.users.push(newUser);
        }
      }
    );
  }

  public getUser(id: number){
    this.http.get<any>(BASE_URL + id).subscribe(
      response => {
        this.user = response;
      }
    );
  }

  public getUsers(): Observable<User[]> {
    return this.http.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }

  public getStudents(): Observable<User[]> {
    return this.http.get(BASE_URL + 'students', {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }

  public getInstructors(): Observable<User[]> {
    return this.http.get(BASE_URL + 'instructors', {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }


  removeUser(id: number) {
    return this.http.delete(BASE_URL + id, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ).subscribe(response => {
      const data: any = response; } );
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

  postImage (user: User, form: FormData) {
    const ROUTE = BASE_URL + user.id + '/image';
    console.log(ROUTE);
    return this.http.post(ROUTE, form)
      .pipe(
        catchError(error => this.handleError(error))
      );
  }
}
