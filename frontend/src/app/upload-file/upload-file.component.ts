import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { HttpClient } from '@angular/common/http';
import {CourseService} from '../services/course/course.service';
@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent implements OnInit {
  form: FormGroup;
  constructor(
    public fb: FormBuilder,
    private http: HttpClient,
    public courseService: CourseService
  ) {
    this.form = this.fb.group({
      img: [null]
    })
  }

  ngOnInit(): void {
  }
  upload(event) {
    const file = (event.target as HTMLInputElement).files[0];
    this.form.patchValue({
      img: file
    });
    this.form.get('img').updateValueAndValidity()
  }
  submit() {
    var formData: any = new FormData();
    formData.append("img", this.form.get('img').value);

    this.courseService.postImage(20, formData).subscribe(
      (response) => console.log(response),
      (error) => console.log(error)
    )
  }
}
