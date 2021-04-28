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

  constructor(private router: Router, public service: UserService, activatedRoute: ActivatedRoute) {
    const id = activatedRoute.snapshot.params['id'];
    service.getUser(id).subscribe(
      user => this.user = user,
      error => console.error(error)
    );
  }

  ngOnInit(): void {
  }

}
