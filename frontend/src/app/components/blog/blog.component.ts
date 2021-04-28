import { Component, OnInit } from '@angular/core';
import {Post} from '../../models/Post/post.model';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class BlogComponent implements OnInit {
  post: Post;
  posts: Post[];
  //para el commit
  restOfPosts: Post;
  constructor() { }

  ngOnInit(): void {
  }

}
