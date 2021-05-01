/*import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../../models/User/user.model';
import { Observable } from 'rxjs';


const BASE_URL = '/api/auth';

@Injectable({ providedIn: 'root' })
export class LoginService {

  role:string;
  logged: boolean;
  user: User;

  constructor(private http: HttpClient) {
    this.reqIsLogged();
  }

  reqIsLogged() {

    this.http.get('/api/admin/users/me', { withCredentials: true }).subscribe(
      response => {
        this.user = response as User;
        this.logged = true;
      },
      error => {
        if (error.status != 404) {
          console.error('Error when asking if logged: ' + JSON.stringify(error));
        }
      }
    );

  }

  logIn(user: string, pass: string) {

    this.http.post(BASE_URL + "/login", { username: user, password: pass }, { withCredentials: true })
      .subscribe(
        (response) => this.reqIsLogged(),
        (error) => alert("Wrong credentials")
      );

  }

  logOut() {

    return this.http.post(BASE_URL + '/logout', { withCredentials: true })
      .subscribe((resp: any) => {
        console.log("LOGOUT: Successfully");
        this.logged = false;
        this.user = undefined;
      });

  }

  isLogged() {
    return this.logged;
  }

  returnId():number{
    return this.user.id;
  }

  isAdmin() {
    console.log(this.user.rol);
    console.log(this.user.id);
    return this.user.rol =='administrador';

  }

  isInstructor() {
    return this.user && this.user.rol.indexOf('profesor') !== -1;
  }

  isStudent() {
    return this.user && this.user.rol.indexOf('alumno') !== -1;
  }

  currentUser() {
    return this.user;
  }
 */
