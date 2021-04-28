import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {Post} from '../../models/Post/post.model';
import {UserService} from '../../services/user/user.service';
import {CourseService} from '../../services/course/course.service';
import {PostService} from '../../services/post/post.service';
import {environment} from '../../../environments/environment';


@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent {
  constructor() {


  }


}

