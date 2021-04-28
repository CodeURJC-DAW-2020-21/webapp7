import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../models/User/user.model';

const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {

  logged: boolean;
  user: User;

  constructor(private httpClient: HttpClient) {this.reqIsLogged(); }

  // tslint:disable-next-line:typedef
  reqIsLogged() {

    this.httpClient.get('/api/users/me', { withCredentials: true }).subscribe(
      response => {
        this.user = response as User;
        this.logged = true;
      },
      error => {
        // tslint:disable-next-line:triple-equals
        if (error.status != 404) {
          console.error('Error when asking if logged: ' + JSON.stringify(error));
        }
      }
    );

  }

  // tslint:disable-next-line:typedef
  logIn(user: string, pass: string) {

    this.httpClient.post(BASE_URL + '/login', { username: user, password: pass }, { withCredentials: true })
      .subscribe(
        (response) => this.reqIsLogged(),
        (error) => alert('Wrong credentials')
      );

  }

  // tslint:disable-next-line:typedef
  logOut() {
    return this.httpClient.post(BASE_URL + '/logout', { withCredentials: true })
      .subscribe((resp: any) => {
        console.log('LOGOUT: Successfully');
        this.logged = false;
        this.user = undefined;
      });

  }

  // tslint:disable-next-line:typedef
  isLogged() {
    return this.logged;
  }

  // tslint:disable-next-line:typedef
  isAdmin() {
    return this.user && this.user.role.indexOf('ADMIN') !== -1;
  }

  // tslint:disable-next-line:typedef
  currentUser() {
    return this.user;
  }
}
