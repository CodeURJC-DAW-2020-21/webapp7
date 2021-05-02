import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/User/user.model';
import {UserService} from '../../services/user/user.service';
import {LoginService} from '../../services/login/login.services';
import {CourseService} from '../../services/course/course.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CommentService} from '../../services/comment/comment.services';

@Component({
  template: `<!--START STUDENTS LIST-->
  <div class="row">
    <div class="col-xl-12 col-lg-12">
      <div class="card shadow mb-4">
        <div class="card-header2 py-3 d-flex flex-row align-items-center justify-content-between">
          <h6 class="m-0 font-weight-bold" style="color: black;">¡ESCRIBE TU OPINIÓN DE NUESTRA ACADEMIA!</h6>
        </div>
        <div class="card-body">

          <form action="/student/comment/createNew" method="post" enctype="multipart/form-data">
            <div class="form-group">
              <label for="name">Nombre *</label>
                <input #name type="text"class="form-control" placeholder="nombre de usuario"/>
            </div>

            <div class="form-group">
              <label for="opinion"> Comentario *</label>
              <input #comment type="text"class="form-control" placeholder="escribe aquí tu comentario"/>
            </div>
            <div class="form-group">
              <input type="submit" value="Crear" class="btn py-3 px-4 btn-primary"
                     (click)="createComment($event, name.value, comment.value)">
            </div>
          </form>

        </div>
      </div>
    </div>
  </div>
  <!--END STUDENTS LIST-->
  `,
  // tslint:disable-next-line:component-selector
  selector: 'app-userStudentComment',
  styleUrls: ['../../../assets/css/style.css']
})

export class UserStudentCommentComponent {
  comment: Comment;
  newComment: boolean;
  form: FormGroup;
  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private commentService: CommentService,
    public fb: FormBuilder)
  { }
  // tslint:disable-next-line:typedef
  createComment(event: any, name: string, comment: string){
    event.preventDefault();
    this.commentService.addComment(name, comment).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }
}
