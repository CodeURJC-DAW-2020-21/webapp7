
import { Component, OnInit } from '@angular/core';
import {Post} from '../../models/Post/post.model';
import {PostService} from '../../services/post/post.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class BlogComponent implements OnInit {
  post: Post;
  posts: Post[];
  restOfPosts: Post;

  constructor(private router: Router,
              public postService: PostService,
              activateRoute: ActivatedRoute) {

    const id = activateRoute.snapshot.params['id'];

    postService.getPosts().subscribe(
      posts => this.posts = posts,
      error => console.error(error)
    );




  }

  ngOnInit(): void {
  }

}
