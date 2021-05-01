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
    httpClient: HttpClient) {}

  createUser(event: any, name: string, email: string, password: string, role:string){
    event.preventDefault();
    this.userService.addUser(name, email, password, role).subscribe(
      response => console.log(response),
      error =>console.log(error)
    );
  }
}
