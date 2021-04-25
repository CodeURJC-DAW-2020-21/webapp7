import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';

const BASE_URL = environment.apiBase + '/courses/';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  createPost(postData: FormData){
    return this.http.post(BASE_URL, postData).pipe(
      catchError(error => this.handleError(error))
    );
  }
  // tslint:disable-next-line:typedef
  public getPost(id: number) {
    const url = environment.apiBase + '/posts/' + id;
    return this.http.get(url);
  }
  // tslint:disable-next-line:typedef
  public getPostPage(page: number){
    const url = environment.apiBase + '/posts?page=' + page;
    return this.http.get(url);
  }

  // tslint:disable-next-line:typedef
  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

}
