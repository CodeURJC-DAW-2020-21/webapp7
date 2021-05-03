import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CommentService} from '../../services/comment/comment.services';
import {Comment} from '../../models/Comment/comment.model';
import { User } from 'src/app/models/User/user.model';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class AboutComponent implements OnInit {

  comments: Comment[];
  comment: Comment;
  newComment: boolean;
  users: User[];
  users_size: number;

  constructor(private router: Router,
              public commentService: CommentService,
              public userService: UserService,
              activateRoute: ActivatedRoute){

    const id = activateRoute.snapshot.params['id'];

    commentService.getComments().subscribe(
      comments => this.comments = comments,
      error => console.error(error)
    );



  }


  ngOnInit(): void {
  }

}
