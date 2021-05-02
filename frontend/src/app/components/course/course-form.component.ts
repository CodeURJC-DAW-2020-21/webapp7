import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Course} from '../../models/Course/course.model';
import {CourseService} from '../../services/course/course.service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-courseForm',
  templateUrl: './course-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class CourseFormComponent {
  course: Course;
  newCourse: boolean;
  form: FormGroup;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private courseService: CourseService,
    public fb: FormBuilder,
    httpClient: HttpClient)
  {this.form = this.fb.group({imageFile: [null]});}

  ngOnInit(){}

  reLoad(){
    window.location.reload();
  }

  createCourse(event: any, category: string, ageStart: string, ageEnd: string, instructor: string, price: string){
    event.preventDefault();
    const start = Number(ageStart);
    const end = Number(ageEnd);
    const pr = Number(price);
    this.courseService.addCourse(category, start, end, instructor, pr).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }

  uploadFile(event) {
    const file = (event.target as HTMLInputElement).files[0];
    this.form.patchValue({
      imageFile: file
    });
    this.form.get('imageFile').updateValueAndValidity()
  }

  submitForm() {
    var formData: any = new FormData();
    formData.append("imageFile", this.form.get('imageFile').value);

    this.courseService.postImage( 20 , formData).subscribe(
      (response) =>console.log(this.form.value),
      (error) => console.log(error)
    )
  }
}
