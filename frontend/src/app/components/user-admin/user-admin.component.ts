import { User } from '../../models/User/user.model';
import {Course} from '../../models/Course/course.model';
import {Post} from '../../models/Post/post.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {HttpClient} from '@angular/common/http';
import { Component, OnInit, ViewChild, ElementRef  } from '@angular/core';
import { HttpEventType, HttpErrorResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { UploadService} from '../../services/upload.service';




@Component({
  selector: 'app-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserAdminComponent{
  courses: Course[];
  users: User[];
  user: User;
  newUser: boolean;
  post: Post;
  newPost: boolean;
  course: Course;
  newCourse: boolean;

  @ViewChild("fileUpload", {static: false}) fileUpload: ElementRef;files  = [];
  constructor(
    private router: Router,
    private uploadService: UploadService,
    activatedRoute: ActivatedRoute,
    private userService: UserService,
    httpClient: HttpClient) {




    //get course id
    //return http.put en servicio que corresponde con AdminUserController Api

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

  // tslint:disable-next-line:typedef
  cancel() {
    window.history.back();
  }

  // tslint:disable-next-line:typedef
  save() {
    this.userService.addUser(this.user).subscribe(
      (user: User) => this.router.navigate(['/users/', user.id]),
      error => alert('Error creating new book: ' + error)
    );

  }
  uploadFile(file) {
    const formData = new FormData();
    formData.append('file', file.data);
    file.inProgress = true;
    this.uploadService.upload(formData).pipe(
      map(event => {
        switch (event.type) {
          case HttpEventType.UploadProgress:
            file.progress = Math.round(event.loaded * 100 / event.total);
            break;
          case HttpEventType.Response:
            return event;
        }
      }),
      catchError((error: HttpErrorResponse) => {
        file.inProgress = false;
        return of(`${file.data.name} upload failed.`);
      })).subscribe((event: any) => {
      if (typeof (event) === 'object') {
        console.log(event.body);
      }
    });
  }
  private uploadFiles() {
    this.fileUpload.nativeElement.value = '';
    this.files.forEach(file => {
      this.uploadFile(file);
    });
  }

  onClick() {
    const fileUpload = this.fileUpload.nativeElement;fileUpload.onchange = () => {
      for (let index = 0; index < fileUpload.files.length; index++)
      {
        const file = fileUpload.files[index];
        this.files.push({ data: file, inProgress: false, progress: 0});
      }
      this.uploadFiles();
    };
    fileUpload.click();
  }


}

