import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User/user.model';
import {UserService} from '../../services/user/user.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-instructor',
  templateUrl: './instructor.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class InstructorComponent implements OnInit {

  user: User;
  users: User[];
  newUser: boolean;

  constructor(private router: Router, public service: UserService, activatedRoute: ActivatedRoute) {
    const id = activatedRoute.snapshot.params['id'];
    service.getInstructors().subscribe(
        users => this.users = users,
        error => console.error(error)
      );
  }

  ngOnInit(): void {
  }

}

