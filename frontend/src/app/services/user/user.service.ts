import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
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

  constructor(private http: HttpClient) { }

  //cuando iniciamos app guardamos la lista de  usuarios
  ngOnInit(){ this.getUsersList()}

  // tslint:disable-next-line:typedef
  addUser(name: string, email: string, password: string, role:string): Observable<Course>{
    return this.http.post(BASE_URL, {name, email, password, role}, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Course>;
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


  // tslint:disable-next-line:typedef
  public getUser(id: number  ): Observable<User> {
    const url = BASE_URL + id;
    return this.http.get(url).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User>;
  }
/*
  getCourse(category: string) {
    this.http.get<any>(BASE_URL + category).subscribe(
      response => {
        this.course = response;
      }
    );
  }

 */
  public getUsers(): Observable<User[]> {
    return this.http.get(BASE_URL, {withCredentials:true}).pipe(
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

  // tslint:disable-next-line:typedef
  removeUser(user: User) {
    return this.http.delete(BASE_URL + user.id, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    );
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }
  postImage (idUser: number, form: FormData){

    return this.http.post(BASE_URL + idUser + '/image', form).pipe(
      catchError(error => this.handleError(error))
    );

  }
/*
  probandoCositas(){
    //lista de usuarios
    this.userService.getUser(this.);
    let users=this.userService.users;
    for (let i = 0; i < users.length; i++){
      if (users[i].id === this.loginService.returnId()){
        this.role = users[i].role;
      }
    }
  }

 */



}
