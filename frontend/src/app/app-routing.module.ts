import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent} from './components/index/index.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {AboutComponent} from './components/about/about.component';
import {BlogSingleComponent} from './components/blogSingle/blogSingle.component';
import {BlogSingle2Component} from './components/blogSingle2/blogSingle2.component';
import {BlogSingle3Component} from './components/blogSingle3/blogSingle3.component';
import {BlogComponent} from './components/blog/blog.component';
import {ContactComponent} from './components/contact/contact.component';
import {CourseComponent} from './components/course/course.component';
import {InstructorComponent} from './components/instructor/instructor.component';
import {UserStudentComponent} from './components/user-student/user-student.component';
import {UserInstructorComponent} from './components/user-instructor/user-instructor.component';
import {UserAdminComponent} from './components/user-admin/user-admin.component';

const routes: Routes = [
  {
    path: 'index', component: IndexComponent,
  },
  {
    path: 'header', component: HeaderComponent,
  },
  {
    path: 'footer', component: FooterComponent,
  },
  {
  path: 'about', component: AboutComponent,
  },
  {
  path: 'blogSingle2', component: BlogSingle2Component,
  },
  {
  path: 'blogSingle', component: BlogSingleComponent,
  },
  {
  path: 'blogSingle3', component: BlogSingle3Component,
  },
  {
    path: 'blog', component: BlogComponent,
  },
  {
    path: 'contact', component: ContactComponent,
  },
  {
    path: 'course', component: CourseComponent,
  },
  {
    path: 'instructor', component: InstructorComponent,
  },
  {
    path: 'user-student', component: UserStudentComponent,
  },
  {
    path: 'user-instructor', component: UserInstructorComponent,
  },
  {
    path: 'user-admin', component: UserAdminComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
