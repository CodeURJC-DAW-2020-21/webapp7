import {Component, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-courseForm',
  templateUrl: './course-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class CourseFormComponent {

  public course: Course = new Course() ;
  public category = 'hols';
  newCourse: boolean;

  @ViewChild("file")
  file: any;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private courseService: CourseService,
    public fb: FormBuilder)
    {}

    // tslint:disable-next-line:typedef
    ngOnInit(){}

  // tslint:disable-next-line:typedef
  createCourse() {
    this.courseService.addCourse(this.course).subscribe(
      (course: Course) => this.uploadImage(course),
      error => alert('Error creating new course: ' + error)
    );
  }

  uploadImage(course: Course): void {

    const imageFile = this.file.nativeElement.files[0];
    if (imageFile) {
      let formData = new FormData();
      formData.append("imageFile", imageFile);
      console.log(formData);
      this.courseService.postImage(course, formData).subscribe(
        _ => this.afterUploadImage(course),
        error => alert('Error uploading course image: ' + error)
      );
    } else {
      this.afterUploadImage(course);
    }

  }

  private afterUploadImage(course: Course){
    this.router.navigate(['/', course.id]);
  }


  courseImage() {
    let imageUrl = '';
    if(this.course.imageFile) {
      imageUrl = '/api/courses/' + this.course.id + '/image';
    } else {
      imageUrl = '/assets/images/no_image.png';
    }
    return imageUrl;
  }
}
