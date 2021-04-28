import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User/user.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-userform',
  templateUrl: './user-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserFormComponent {
  user: User;
  newUser: boolean;

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

  cancel() {
    window.history.back();
  }
/*
  save() {
    this.userService.addUserToACourse(this.user,this.course).subscribe(
      (user: User) => this.router.navigate(['/users/', user.id]),
      error => alert('Error creating new book: ' + error)
    );

  }

 */
}
