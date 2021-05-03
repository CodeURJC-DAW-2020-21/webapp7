import {Component, OnInit, ViewChild} from '@angular/core';
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
  display = false;
  course: Course;
  materialDelete: Material;
  @ViewChild("file")
  file: any;

  constructor(private router: Router, public materialService: MaterialService, activatedRoute: ActivatedRoute,
              public loginService: LoginService) {
    const id = activatedRoute.snapshot.params['id'];
    materialService.getMaterial().subscribe(
      materials => this.materials = materials,
      error => console.error(error),
    );
    console.log('materials ' + this.materials);
  }
  ngOnInit(): void {
  }

  updateMaterial() {
    this.materialService.addMaterial({name:" "}).subscribe(
      (material: Material) => this.uploadElement(material),
      error => alert('Error creating new course: ' + error)
    );
  }
  uploadElement(material: Material): void {

    const content = this.file.nativeElement.files[0];
    if (content) {
      let formData = new FormData();
      formData.append("multipartFile", content);
      console.log(formData);
      this.materialService.postElement(material, formData).subscribe(
        _ => this.afterUploadElement(material),
        error => alert('Error uploading course image: ' + error)
      );
    } else {
      this.afterUploadElement(material);
    }

  }

  private afterUploadElement(material: Material){
    this.router.navigate(['/', material.id]);
  }
  materialElement() {
    let imageUrl = '';
    if(this.material.content) {
      imageUrl = '/api/materials/' + this.material.id + '/file';
    } else {
      imageUrl = '/assets/images/no_image.png';
    }
    return imageUrl;
  }

  deleteMaterial(event: any, id: number){
      event.preventDefault();
      let materialsFind = this.materials;

      for (let i = 0; i < materialsFind.length; i++) {
        if (materialsFind[i].id === id) {
          this.materialDelete = materialsFind[i];
        }
      }
      this.materialService.deleteMaterial(this.materialDelete.id);
    }

  downloadMaterial(event: any, id: number){
    event.preventDefault();
    let materialsFind = this.materials;

    for (let i = 0; i < materialsFind.length; i++) {
      if (materialsFind[i].id === id) {
        this.materialDelete = materialsFind[i];
      }
    }
    this.materialService.downloadMaterial(this.materialDelete.id);
  }
}




