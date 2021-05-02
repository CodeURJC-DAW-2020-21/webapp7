import {Injectable, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';
import {Post} from '../../models/Post/post.model';
import {Course} from '../../models/Course/course.model';

const BASE_URL =  '/api/posts/';

@Injectable({
  providedIn: 'root'
})
export class PostService implements OnInit {
  posts: Post[] = [];
  post: Post;


  constructor(private httpClient: HttpClient) { }
  ngOnInit() {
    this.getPostsList();
  }

  getPosts(): Observable<Post[]> {
    return this.httpClient.get(BASE_URL).pipe(
            catchError(error => this.handleError(error))
        ) as Observable<Post[]>;

  }

  getNextPosts(): Observable<Post[]> {
    return this.httpClient.get('/api/posts/all').pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Post[]>;
  }

  getPost(id: number): Observable<Post> {
    return this.httpClient.get(BASE_URL + id ).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Post>;
  }

  // tslint:disable-next-line:typedef
  addPost(post: Post){

    return this.httpClient.post(BASE_URL, post)
      .pipe(
        catchError(error => this.handleError(error))
      );
  }

  getPostsList() {
    this.httpClient.get<any>(BASE_URL).subscribe(
      response => {
        let data: any = response;
        for (var i = 0; i < data.length; i++) {
          let newPost = data[i];
          this.posts.push(newPost);
        }
      }
    );
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

  postImage (post: Post, form: FormData) {
    const ROUTE = BASE_URL + post.id + '/image';
    console.log(ROUTE);
    return this.httpClient.post(ROUTE, form)
      .pipe(
        catchError(error => this.handleError(error))
      );
  }
}
