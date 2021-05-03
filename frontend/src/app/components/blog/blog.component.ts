
import { Component, OnInit } from '@angular/core';
import {Post} from '../../models/Post/post.model';
import {PostService} from '../../services/post/post.service';
import {ActivatedRoute, Router} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class BlogComponent  {
  post: Post;
  posts: Post[];
  restOfPosts: Post[];
  copy:Post[];
  onlyPost:Post;
  id:number;
  nextPage:number=1;

  public showLoadMore = false;
  public postNumber: number;
  public load:string;

  constructor(private router: Router,
              public postService: PostService,
              activateRoute: ActivatedRoute,
              private http: HttpClient) {

    const id = activateRoute.snapshot.params['id'];

    postService.getPosts().subscribe(
      posts => this.posts = posts,
      error => console.error(error)
    );

  }

  getPost(id:number){
    this.postService.getPost(id).subscribe(
      onlyPost => this.onlyPost = onlyPost,
      error => console.error(error)
    );
  }

  loadMore():void {
      this.http.get<any>('/api/posts/?Page='+this.nextPage).subscribe(
        response => {
          let data: any = response;
          for (var i = 0; i < data.length; i++) {
            let newUserList = data[i];
            this.posts.push(newUserList);
          }
        }
      );
    this.nextPage++;
  }
}
