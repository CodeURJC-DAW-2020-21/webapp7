import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';
import { Material } from 'src/app/models/Material/material.model';
import { User } from 'src/app/models/User/user.model';

const BASE_URL =  '/api/materials/';

@Injectable({
  providedIn: 'root'
})

export class BarChartService implements OnInit{
/*
  materials: Material[] = [];
  material: Material;
  users:User[] = [];
  user:User;
 */
  constructor(private http: HttpClient) { }

  public getStudentsInCourseList(): Observable<User[]> {
    console.log(this.http.get(BASE_URL + 'graph'));
    return this.http.get(BASE_URL + 'graph', {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }
  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

  ngOnInit() { }

/*
  ngOnInit(){ this.getStudentsInCourseList(); }

  public getStudentsInCourseList(){
    this.http.get<any>(BASE_URL + 'graph').subscribe(
      response => {
        let data: any = response;
        console.log(data);
        for (var i = 0; i < data.length; i++) {
          let newUserList = data[i];
          console.log(newUserList);
          this.users.push(newUserList);
        }
      }
    );
  }

 */
}
