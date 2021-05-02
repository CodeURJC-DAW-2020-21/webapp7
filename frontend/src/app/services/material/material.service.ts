import { Injectable, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {User} from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {Material} from '../../models/Material/material.model';


const BASE_URL = '/api/materials/';

@Injectable({
  providedIn: 'root'
})

export class MaterialService implements OnInit{

  constructor(private http: HttpClient) { }

  public getRecomendations(): Observable<Material[]> {
    return this.http.get(BASE_URL + 'recommendations', {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Material[]>;
  }

  public getMaterial(): Observable<Material[]> {
    return this.http.get(BASE_URL, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Material[]>;
  }
  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

  ngOnInit() {
  }
}
