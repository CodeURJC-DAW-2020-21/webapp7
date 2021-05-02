import {Component, OnInit, ViewChild} from '@angular/core';
import { User } from '../../models/User/user.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-userform',
  templateUrl: './user-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserFormComponent {
  public user: User = new User() ;
  newUser: boolean;
  @ViewChild("file")
  file: any;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private userService: UserService,
    public fb: FormBuilder)
  {}
  ngOnInit(){}

  createUser() {
    this.userService.addUser(this.user).subscribe(
      (user: User) => this.uploadImage(user),
      error => alert('Error creating new user: ' + error)
    );
  }

  uploadImage(user: User): void {

    const imageFile = this.file.nativeElement.files[0];
    if (imageFile) {
      let formData = new FormData();
      formData.append("imageFile", imageFile);
      console.log(formData);
      this.userService.postImage(user, formData).subscribe(
        _ => this.afterUploadImage(user),
        error => alert('Error uploading user image: ' + error)
      );
    } else {
      this.afterUploadImage(user);
    }

  }

  private afterUploadImage(user: User){
    this.router.navigate(['/', user.id]);
  }


  userImage() {
    let imageUrl = '';
    if(this.user.imageFile) {
      imageUrl = '/api/users/' + this.user.id + '/image';
    } else {
      imageUrl = '/assets/images/no_image.png';
    }
    return imageUrl;
  }
}
