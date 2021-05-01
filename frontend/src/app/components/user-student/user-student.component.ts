import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User/user.model';
import {Material} from '../../models/Material/material.model';

@Component({
  selector: 'app-userstudent',
  templateUrl: './user-student.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserStudentComponent implements OnInit {
  user: User;
  materials: Material[];

  constructor() {
  }

  ngOnInit(): void {
  }

}
