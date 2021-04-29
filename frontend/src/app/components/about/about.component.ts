import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CommentService} from '../../services/comment/comment.services';
import {Comment} from '../../models/Comment/comment.model';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class AboutComponent implements OnInit {


  comment: Comment;
  newComment: boolean;

  constructor(private router: Router, public service: CommentService, activateRoute: ActivatedRoute){

    const id = activateRoute.snapshot.params['id'];

    if (id){
      service.getComment(id).subscribe(
        comment => this.comment = comment,
        error => console.error(error)
      );
      this.newComment = false;
    }else{
      this.comment = {
        name: '',
        comment: ''
      };
      this.newComment = true;
    }
  }


  ngOnInit(): void {
  }

}
