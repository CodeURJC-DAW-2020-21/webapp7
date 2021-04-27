import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {Post} from '../../models/Post/post.model';
import {UserService} from '../../services/user/user.service';
import {CourseService} from '../../services/course/course.service';
import {PostService} from '../../services/post/post.service';
import {environment} from '../../../environments/environment';
import {Router} from '@angular/router';


@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent {

  user: User;
  course: Course;
  post: Post;
  userData: FormData;
  courseData: FormData;
  postData: FormData;

  constructor(private router: Router,
              private userService: UserService,
              private courseService: CourseService,
              private postService: PostService) {
    this.userData = new FormData();
    this.courseData = new FormData();
    this.postData = new FormData();
    this.user = {
      email: '',
      name: '',
      password: '',
      role: '',
      image: false,
      numberMaterials: 0
    };
    this.course = {
      category: '',
      ageStart: 0,
      ageEnd: 0,
      instructor: '',
    };
    this.post = {
      title: '',
      description: '',
      image: false
    };

  }

  // tslint:disable-next-line:typedef
  createUser( formulary: NgForm ) {

    if ( formulary.invalid ) {
      Object.values(formulary.controls).forEach( control => {
        control.markAsTouched();
      });
    }

    else {
      this.userData.append('jsondata', JSON.stringify(this.user));
      this.userData.append('password', this.user.password);

      this.userService.createUser(this.userData).subscribe(
        response => {
          this.router.navigate(['user-admin']);
        },
        error => {
            this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
            this.router.navigate(['user-admin']);
          });
        }
      );
    }
  }


  // tslint:disable-next-line:typedef
  createCourse( formulary: NgForm ) {
    if ( formulary.invalid ) {

      Object.values(formulary.controls).forEach( control => {
        control.markAsTouched();
      });
    }

    else {
      this.courseData.append('jsondata', JSON.stringify(this.course));

      this.courseService.createCourse(this.courseData).subscribe(
        response => {
          this.router.navigate(['index']);
        },
        error => {
          this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/user-admin']);
          });
        }
      );
    }
  }

  // tslint:disable-next-line:typedef
  createPost( formulary: NgForm ) {
    if ( formulary.invalid ) {

      Object.values(formulary.controls).forEach( control => {
        control.markAsTouched();
      });
    }

    else {

      this.postData.append('jsondata', JSON.stringify(this.post));

      this.postService.createPost(this.postData).subscribe(
        response => {
          this.router.navigate(['index']);
        },
        error => {
          this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/user-admin']);
          });
        }
      );
    }
  }


}

