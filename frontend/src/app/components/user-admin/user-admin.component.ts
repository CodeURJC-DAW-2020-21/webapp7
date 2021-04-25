import { Component } from '@angular/core';
import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {UserService} from '../../services/user.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent {

  user: User;
  course: Course;
  data: FormData;
  alert: boolean;
  alertText: string;

  constructor(private router, private userService: UserService) {
    this.user = {
      email: '',
      name: '',
      password: '',
      role: '',
      image: false,
      numberMaterials: 0
    };
  }

  // tslint:disable-next-line:typedef
  createUser( formulary: NgForm ) {

    if ( formulary.invalid ) {
      this.alertText = 'All fields must be Completed';
      this.alert = true;

      Object.values(formulary.controls).forEach( control => {
        control.markAsTouched();
      });
    }

    else {
      this.alert = false;

      this.data.append('jsondata', JSON.stringify(this.user));
      this.data.append('password', this.user.password);

      this.userService.createUser(this.data).subscribe(
        response => {
          this.router.navigate(['home']);
        },
        error => {
          this.alertText = `El usuario no se pudo crear. \nContacte al servicio técnico.`;
          this.alert = true;
          this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
            this.router.navigate(['user-admin']);
          });
        }
      );
    }
  }

}
