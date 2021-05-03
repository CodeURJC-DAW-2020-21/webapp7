import {Component, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PostService} from '../../services/post/post.service';
import {FormBuilder} from '@angular/forms';
import {Post} from '../../models/Post/post.model';

@Component({
  selector: 'app-blogform',
  templateUrl: './blog-form.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class BlogFormComponent {
  newPost: boolean;
  public post: Post = new Post() ;

  @ViewChild("file")
  file: any;

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private postService: PostService,
    public fb: FormBuilder) {}

  // tslint:disable-next-line:typedef
  ngOnInit(){}

  createPost() {
    this.postService.addPost(this.post).subscribe(
      (post: Post) => this.uploadImage(post),
      error => alert('Error creating new post: ' + error)
    );
  }

  uploadImage(post: Post): void {

    const imageFile = this.file.nativeElement.files[0];
    if (imageFile) {
      let formData = new FormData();
      formData.append("imageFile", imageFile);
      console.log(formData);
      this.postService.postImage(post, formData).subscribe(
        _ => this.afterUploadImage(post),
        error => alert('Error uploading post image: ' + error)
      );
    } else {
      this.afterUploadImage(post);
    }

  }

  private afterUploadImage(post: Post){
    this.router.navigate(['/', post.id]);
  }


  PostImage() {
    let imageUrl = '';
    if(this.post.imageFile) {
      imageUrl = '/api/post/' + this.post.id + '/image';
    } else {
      imageUrl = '/assets/images/no_image.png';
    }
    return imageUrl;
  }
}
