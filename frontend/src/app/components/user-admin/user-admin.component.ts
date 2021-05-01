import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {Post} from '../../models/Post/post.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {HttpClient} from '@angular/common/http';
import { Component, OnInit, ViewChild, ElementRef  } from '@angular/core';
import {LoginService} from '../../services/login/login.services';





@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent{
  courses: Course[];
  users: User[];
  user: User;
  newUser: boolean;
  post: Post;
  newPost: boolean;
  course: Course;
  newCourse: boolean;

  @ViewChild("fileUpload", {static: false}) fileUpload: ElementRef;files  = [];
  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private userService: UserService,
    httpClient: HttpClient, public loginService: LoginService) {}



/*
  ESTO ES ANTIGUOO
    //get course id
    //return http.put en servicio que corresponde con AdminUserController Api

    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      userService.getUser(id).subscribe(
        user => user = user,
        error => console.error(error)
      );
      this.newUser = false;
    } else {
      this.user = {email: '', name: '', password: '', role: '', image: false, numberMaterials: 0};
      this.newUser = true;
    }
  }

  // tslint:disable-next-line:typedef
  cancel() {
    window.history.back();
  }

  // tslint:disable-next-line:typedef
  save() {
    this.userService.addUser(this.user).subscribe(
      (user: User) => this.router.navigate(['/users/', user.id]),
      error => alert('Error creating new book: ' + error)
    );

  }*/



}

