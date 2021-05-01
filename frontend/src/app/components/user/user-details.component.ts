import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/User/user.model';


@Component({
  template: `<!--DELETE STUDENT/TEACHER-->
  <div class="form-group">
    <label class="label" >Borrar alumno/profesor de la academia</label>
    <form action="/admin/user/delete" method="get" enctype="multipart/form-data">


      <div class="form-group">
        <input  [(ngModel)]="user.email" class="form-control"/>
      </div>

      <input type="submit" value="Borrar" class="btn py-3 px-4 btn-primary">
    </form>
  </div>`,
  selector: 'app-userdetails',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserDetailsComponent {
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

  removeBook() {
    const okResponse = window.confirm('Do you want to remove this user?');
    if (okResponse) {
      this.userService.removeUser(this.user).subscribe(
        _ => this.router.navigate(['/users']),
        error => console.error(error)
      );
    }
  }
}
