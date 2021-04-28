import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent} from './components/index/index.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {FormsModule} from '@angular/forms';
import {UserInstructorComponent} from './components/user-instructor/user-instructor.component';
import {AboutComponent} from './components/about/about.component';
import {UserStudentComponent} from './components/user-student/user-student.component';
import {InstructorComponent} from './components/instructor/instructor.component';
import {BlogComponent} from './components/blog/blog.component';
import {ContactComponent} from './components/contact/contact.component';
import {CourseComponent} from './components/course/course.component';
import {UserAdminComponent} from './components/user-admin/user-admin.component';
import {BlogSingleComponent} from './components/blogSingle/blogSingle.component';
import {BlogSingle2Component} from './components/blogSingle2/blogSingle2.component';
import {BlogSingle3Component} from './components/blogSingle3/blogSingle3.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    HeaderComponent,
    FooterComponent,
    UserInstructorComponent,
    UserStudentComponent,
    InstructorComponent,
    UserAdminComponent,
    AboutComponent,
    BlogComponent,
    ContactComponent,
    CourseComponent,
    BlogSingleComponent,
    BlogSingle2Component,
    BlogSingle3Component
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    // NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
