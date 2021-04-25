import { Component } from '@angular/core';
import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {UserService} from '../../services/user/user.service';
import {NgForm} from '@angular/forms';
import {CourseService} from '../../services/course/course.service';

@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent {

  user: User;
  course: Course;
  userData: FormData;
  courseData: FormData;
  alert: boolean;
  alertText: string;

  constructor(private router, private userService: UserService, private courseService: CourseService) {
    this.userData = new FormData();
    this.courseData = new FormData();
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
    this.alert = false;
  }

  // tslint:disable-next-line:typedef
  createUser( formulary: NgForm ) {

    if ( formulary.invalid ) {
      this.alertText = 'Todos los campos se deben rellenar';
      this.alert = true;

      Object.values(formulary.controls).forEach( control => {
        control.markAsTouched();
      });
    }

    else {
      this.alert = false;

      this.userData.append('jsondata', JSON.stringify(this.user));
      this.userData.append('password', this.user.password);

      this.userService.createUser(this.userData).subscribe(
        response => {
          this.router.navigate(['home']);
        },
        error => {
          this.alertText = `El usuario no se pudo crear. Contacte al servicio técnico.`;
          this.alert = true;
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
      this.alertText = 'Todos los campos se deben rellenar';
      this.alert = true;

      Object.values(formulary.controls).forEach( control => {
        control.markAsTouched();
      });
    }

    else {
      this.alert = false;

      this.courseData.append('jsondata', JSON.stringify(this.course));

      this.courseService.createCourse(this.courseData).subscribe(
        response => {
          this.router.navigate(['home']);
        },
        error => {
          this.alertText = 'El usuario no se pudo crear. Contacte al servicio técnico.';
          this.alert = true;
          this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
            this.router.navigate(['/shelterform']);
          });
        }
      );
    }
  }
}
