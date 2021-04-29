import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
//comentario ejemplo
import { AppComponent } from './app.component';
// import {Router} from '@angular/router';
// import {RouterModule} from '@angular/router';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { IndexComponent} from './components/index/index.component';
import {UserInstructorComponent} from './components/user-instructor/user-instructor.component';
import {AboutComponent} from './components/about/about.component';
import {BlogSingleComponent} from './components/blogSingle/blogSingle.component';
import {BlogSingle2Component} from './components/blogSingle2/blogSingle2.component';
import {BlogSingle3Component} from './components/blogSingle3/blogSingle3.component';
import {UserStudentComponent} from './components/user-student/user-student.component';
import {UserAdminComponent} from './components/user-admin/user-admin.component';
import {ContactComponent} from './components/contact/contact.component';
import {CourseComponent} from './components/course/course.component';
import {InstructorComponent} from './components/instructor/instructor.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {BlogComponent} from './components/blog/blog.component';
import {UserFooterComponent} from './components/footer/userFooter.component';
import {UserFormComponent} from './components/user/user-form.component';
import {BlogFormComponent} from './components/blog/blog-form.component';
import {CourseFormComponent} from './components/course/course-form.component';
import {CourseDetailsComponent} from './components/course/course-details.component';
import {UserDetailsComponent} from './components/user/user-details.component';
import {UserStudentListComponent} from './components/user/user-student-list.component';
import {UserInstructorListComponent} from './components/user/user-instructor-list.component';
import {CourseListComponent} from './components/course/course-list-component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {LoginComponent} from './components/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UserFooterComponent,
    IndexComponent,
    UserInstructorComponent,
    UserStudentComponent,
    UserAdminComponent,
    AboutComponent,
    ContactComponent,
    CourseComponent,
    InstructorComponent,
    BlogSingleComponent,
    BlogSingle2Component,
    BlogSingle3Component,
    BlogComponent,
    UserFormComponent,
    BlogFormComponent,
    CourseFormComponent,
    CourseDetailsComponent,
    UserDetailsComponent,
    UserStudentListComponent,
    UserInstructorListComponent,
    CourseListComponent,
    LoginComponent


  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    NgbModule
    // NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
