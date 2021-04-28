import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {User} from '../../models/User/user.model';

const BASE_URL = environment.apiBase + '/users/';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  createUser( userData: FormData ) {
    return this.http.post(BASE_URL, userData).pipe(
      catchError(error => this.handleError(error))
    );
  }
  // tslint:disable-next-line:typedef
  public getUser(id: number | string): Observable<User> {
    const url = BASE_URL + id;
    return this.http.get(url).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User>;
  }

  public getUsers(): Observable<User[]> {
    return this.http.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

}
