import { Component, OnInit } from '@angular/core';
import {Comment} from '../../models/Comment/comment.model';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class AboutComponent implements OnInit {
  comment:Comment;
  constructor() { }

  ngOnInit(): void {
  }

}
