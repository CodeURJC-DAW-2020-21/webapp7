import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../../models/User/user.model';
import {UserService} from '../../services/user/user.service';

@Component({
  template: `
    <!--DELETE USERS--><div class="form-group">
      <label class="label" >Borrar alumno/profesor del curso</label>
      <!-- EL NOMBRE DEL ACTION DE ABAJO ES EL QUE ESTA EN EL TEMPLATE, AUNQUE PONGA COURSE-->
      <form action="/admin/user/deletecourse" method="get" enctype="multipart/form-data">
        <div class="form-group">
          <input #email type="text" class="form-control"/>
        </div>
        <input type="submit" value="BORRAR" class="btn py-3 px-4 btn-primary"
               (click)="removeUser($event, email.value)">
      </form>
    </div>`,
  // tslint:disable-next-line:component-selector
  selector: 'app-usersDelete',
  styleUrls: ['../../../assets/css/style.css']
})

export class UsersDeleteComponent implements OnInit{
  user: User;
  newUser: boolean;

    constructor(
      private router: Router,
      activatedRoute: ActivatedRoute,
      private userService: UserService,
      httpClient: HttpClient) {
    }

  removeUser(event: any, id: string) {
    event.preventDefault();
    const okResponse = window.confirm('Do you want to remove this user?');
    if (okResponse) {
      let list = this.userService.users;
      console.log('lista list: ' + list);
      for (let i = 0; i < list.length; i++){
        if (list[i].name === id){
          this.userService.removeUser(this.userService.users[i].id);
        }
      }
    }
  }
  ngOnInit() {
    this.userService.getUsersList();
  }

}

