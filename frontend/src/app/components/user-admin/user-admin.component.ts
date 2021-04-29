import {Component} from '@angular/core';
import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {Post} from '../../models/Post/post.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent {
  courses: Course[];
  users: User[];
  user: User;
  newUser: boolean;
  post: Post;
  newPost: boolean;
  course: Course;
  newCourse: boolean;


  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private userService: UserService,
    httpClient: HttpClient) {

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

  }

}


