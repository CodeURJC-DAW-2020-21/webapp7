import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User/user.model';
import { LoginService } from 'src/app/services/login/login.services';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
users:User[];
rol:string;
user:User;

  constructor(public loginService: LoginService ,public userService: UserService ,private router: Router) { }

  logIn(event: any, user: string, pass: string) {

    event.preventDefault();

    this.loginService.logIn(user, pass);

    console.log(this.loginService.isAdmin());
/*
    //lista de usuarios
    this.userService.getUser(this.user.id);
    let users=this.userService.users;
    for (let i = 0; i < users.length; i++){
      if (users[i].id === this.loginService.returnId()){
        this.rol = users[i].rol;
      }
    }

 */

    //console.log(this.rol);
    //console.log(this.rol==='administrador');

    if (this.loginService.isAdmin()){
      this.router.navigate(['/user-admin']);
    }
    if (this.loginService.isInstructor()){
      this.router.navigate(['/user-instructor']);
    }
    if (this.loginService.isStudent()){
      this.router.navigate(['/user-student']);
    }

  }

}
