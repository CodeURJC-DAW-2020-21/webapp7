import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/User/user.model';
import {UserService} from '../../services/user/user.service';
import {LoginService} from '../../services/login/login.services';

@Component({
  template: `<!--START STUDENTS LIST-->
  <div class="row">
    <div class="col-lg-12 mb-12">
      <div class="card shadow mb-4">
        <div class="card-header2 py-3">
          <h6 class="m-0 font-weight-bold" style="color: black;">ALUMNOS</h6>

        </div>
        <div class="card-body">
          <div class="input-group">
            <div class="input-group-append">
              <div class="card-body">
                <li *ngFor="let user of users">
                  <a >{{user.name}}</a>
                </li>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--END STUDENTS LIST-->
  `,
  // tslint:disable-next-line:component-selector
  selector: 'app-userStudentList',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserStudentListComponent {
  user: User;
  users: User[];

  constructor(private router: Router, private userService: UserService, public loginService: LoginService) { }

  // tslint:disable-next-line:typedef use-lifecycle-interface
  ngOnInit() {
    this.userService.getUsers().subscribe(
      users => this.users = users,
      error => console.log(error)
    );
  }

  // tslint:disable-next-line:typedef
  newUser() {
    this.router.navigate(['/users/new']);
  }
}

