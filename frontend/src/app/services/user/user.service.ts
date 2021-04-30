import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {User} from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';


const BASE_URL = '/api/users/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
 addUser( user: User ) {
    return this.http.post(BASE_URL, user).pipe(
      catchError(error => this.handleError(error))
    );
  }
/*
  addUserToACourse(user: User,course:Course){
    course.
  }

 */
  // tslint:disable-next-line:typedef
  public getUser(id: number | string): Observable<User> {
    const url = BASE_URL + id;
    return this.http.get(url).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User>;
  }

  public getUsers(): Observable<User[]> {
    return this.http.get(BASE_URL, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }


  // tslint:disable-next-line:typedef
  removeUser(user: User) {
    return this.http.delete(BASE_URL + user.id).pipe(
      catchError(error => this.handleError(error))
    );
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

}
