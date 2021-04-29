import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {PostService} from '../../services/post/post.service';
import {Post} from '../../models/Post/post.model';

@Component({
  selector: 'app-blogform',
  templateUrl: './blog-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class BlogFormComponent {
  post: Post;
  newPost: boolean;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private postService: PostService,
    httpClient: HttpClient) {

    const id = activatedRoute.snapshot.params['id'];
    if (id) {
      postService.getPost(id).subscribe(
        post => this.post = post,
        error => console.error(error)
      );
      this.newPost = false;
    } else {
      this.post = { title: '', description:'',image:false };
      this.newPost = true;
    }
  }

  cancel() {
    window.history.back();
  }

  save() {
    this.postService.addPost(this.post).subscribe(
      (post: Post) => this.router.navigate(['/posts/', post.id]),
      error => alert('Error creating new post: ' + error)
    );

  }
}
