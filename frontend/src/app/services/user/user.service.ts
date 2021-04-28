import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {User} from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';

const BASE_URL = environment.apiBase + '/users/';

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
  public getUser(id: number) {
    const url = environment.apiBase + '/users/' + id;
    return this.http.get(url);
  }

  getUsers(): Observable<User[]> {
    return this.http.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }

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
