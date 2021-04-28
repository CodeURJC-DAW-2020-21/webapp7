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
  newUser: boolean;

  constructor(private router: Router, public service: UserService, activatedRoute: ActivatedRoute) {
    const id = activatedRoute.snapshot.params['id'];

    if (id){
      service.getUser(id).subscribe(
        user => this.user = user,
        error => console.error(error)
      );
      this.newUser = false;
    } else {
      this.user = {
        email: '',
        name: 'asfda',
        password: 'asdfa',
        role: 'profesor',
        image: false,
        numberMaterials: 0
      };
      this.newUser = true;
    }
  }

  ngOnInit(): void {
  }

}
