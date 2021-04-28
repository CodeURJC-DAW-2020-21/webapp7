import { Component, OnInit } from '@angular/core';
import {Post} from '../../models/Post/post.model';

@Component({
  selector: 'app-blogSingle',
  templateUrl: './blogSingle.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class BlogSingleComponent implements OnInit {
  post: Post;

  constructor() { }

  ngOnInit(): void {
  }

}
