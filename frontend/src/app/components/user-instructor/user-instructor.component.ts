import { Component, OnInit } from '@angular/core';
import {Material} from '../../models/Material/material.model';
import {User} from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {LoginService} from '../../services/login/login.services';

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

  constructor(public loginService: LoginService) { }

  ngOnInit(): void { }

}




