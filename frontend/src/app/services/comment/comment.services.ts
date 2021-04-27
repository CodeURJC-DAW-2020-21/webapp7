import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { Comment } from '../../models/Post/comment.model';

const BASE_URL = environment.apiBase + '/posts/';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient) { }


  getPosts(): Observable<Post[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Post[]>;
  }

  getPost(id: number): Observable<Post> {
    return this.httpClient.get(BASE_URL + id).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Post>;
  }

  addPost(post: Post){
    if (!post.id) {
      return this.httpClient.post(BASE_URL, post)
        .pipe(
          catchError(error => this.handleError(error))
        );
    } else {
      return this.httpClient.put(BASE_URL + post.id, post).pipe(
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
