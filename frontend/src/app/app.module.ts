import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
// import {Router} from '@angular/router';
// import {RouterModule} from '@angular/router';
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
import {UsersDeleteComponent} from './components/user/users-delete.component';
import {UserStudentListComponent} from './components/user/user-student-list.component';
import {UserInstructorListComponent} from './components/user/user-instructor-list.component';
import {CourseListComponent} from './components/course/course-list-component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {LoginComponent} from './components/login/login.component';
import {Error404Component} from './components/error/error404.component';
import {ErrorComponent} from './components/error/error.component';
import {LoginErrorComponent} from './components/error/loginError.component';
// @ts-ignore
import { ChartsModule } from 'ng2-charts';
import {UserStudentCommentComponent} from './components/user-student/user-student-comment.component'; // <- HERE
import { BarChartComponent } from './components/barChart/barChart.component';
import {AdminAddToCourseComponent} from './components/user-admin/user-admin-add.component';



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
    UsersDeleteComponent,
    UserStudentListComponent,
    UserInstructorListComponent,
    CourseListComponent,
    LoginComponent,
    Error404Component,
    ErrorComponent,
    LoginErrorComponent,
    BarChartComponent,
    UserStudentCommentComponent,
    AdminAddToCourseComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    ChartsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
