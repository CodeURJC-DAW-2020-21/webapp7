import { Component, OnInit } from '@angular/core';
import {Material} from '../../models/Material/material.model';
import {User} from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {LoginService} from '../../services/login/login.services';
import {ActivatedRoute, Router} from '@angular/router';
import {MaterialService} from '../../services/material/material.service';

@Component({
  selector: 'app-user-instructor',
  templateUrl: './user-instructor.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserInstructorComponent implements OnInit {
  materials: Material[];
  material: Material;
  users: User[];
  user: User;
  course: Course;
  constructor(private router: Router, public materialService: MaterialService, activatedRoute: ActivatedRoute,
              public loginService: LoginService) {
    const id = activatedRoute.snapshot.params['id'];
    materialService.getMaterial().subscribe(
      materials => this.materials = materials,
      error => console.error(error)
    );
    console.log('materials ' + this.materials);
  }

  ngOnInit(): void {
  }
}




