// @ts-ignore
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
// @ts-ignore
import { HttpClient } from '@angular/common/http';
// @ts-ignore
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import {Comment} from '../../models/Comment/comment.model';
import { User } from 'src/app/models/User/user.model';
const BASE_URL =  '/api/comment/';
// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private httpClient: HttpClient) { }


  getComments(): Observable<Comment[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Comment[]>;
  }

  getUsers(): Observable<User[]> {
    return this.httpClient.get(BASE_URL, {withCredentials:true}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }



  addComment(comment: Comment){
    if (!comment.id) {
      return this.httpClient.post(BASE_URL, comment, {withCredentials:true})
        .pipe(
          catchError(error => this.handleError(error))
        );
    } else {
      return this.httpClient.put(BASE_URL + comment.id, comment, {withCredentials:true}).pipe(
        catchError(error => this.handleError(error))
      );
    }
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    console.log('ERROR:');
    console.error(error);
    return throwError('Server error (" + error.status + "): ' + error.text());
  }
}
