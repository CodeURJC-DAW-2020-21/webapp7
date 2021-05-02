import { Component, OnInit } from '@angular/core';
import {Post} from '../../models/Post/post.model';
import {ActivatedRoute, Router} from '@angular/router';
import {PostService} from '../../services/post/post.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['../../../assets/css/style.css']
})
export class IndexComponent implements OnInit {

  post: Post;
  posts: Post[];

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
