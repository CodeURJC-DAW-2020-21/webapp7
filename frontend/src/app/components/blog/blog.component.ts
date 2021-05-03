
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
  done:boolean;


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
    this.done=false;
  }

  loadMore():void {
    if(this.done==false){
      this.http.get<any>('/api/posts/all').subscribe(
        response => {
          let data: any = response;
          for (var i = 0; i < data.length; i++) {
            let newUserList = data[i];
            this.posts.push(newUserList);
          }
        }
      );
      this.done=true;
    }
    /*
      this.copy=this.posts;
      for (var i = 3; i <= this.copy.length; i++) {
        this.posts.pop();
      }
      console.log(this.posts);

     */


    /*
    let printContents, popupWin;
    printContents = document.getElementById('loadArea').innerHTML;
    printContents.write(`
      <div  *ngFor="let post of restOfPosts">
          <div class="col-lg-4 ftco-animate" >
            <div class="blog-entry">
              <img src="/post/{{post.id}}/image" class="block-20" >
              <div class="text d-block">
                <h3 class="heading"><a href="post/{{post.id}}">{{morePostsData.title}}</a></h3>
                <p>{{morePostsData.description}}</p>
                <p><a href="post/{{post.id}}" class="btn btn-secondary py-2 px-3">Leer más</a></p>
              </div>
            </div>
          </div>
        </div>`
    );
    */
  }
}
