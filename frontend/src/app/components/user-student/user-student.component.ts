import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User/user.model';
import {Material} from '../../models/Material/material.model';
import {MaterialService} from '../../services/material/material.service';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {LoginService} from '../../services/login/login.services';

@Component({
  selector: 'app-userstudent',
  templateUrl: './user-student.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserStudentComponent implements OnInit {
  user: User;
  materials: Material[];
  recomendation: Material;
  recomendations: Material[];

  constructor(private router: Router, public materialService: MaterialService, activatedRoute: ActivatedRoute,
              public loginService: LoginService) {
    const id = activatedRoute.snapshot.params['id'];
    materialService.getRecomendations().subscribe(
      recomendations => this.recomendations = recomendations,
      error => console.error(error)
    );
    console.log('recomendaciones ' + this.recomendations);
  }

  ngOnInit(): void {
  }

}
