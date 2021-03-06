// @ts-ignore
import {Component, NgModule} from '@angular/core';
// @ts-ignore
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
import {UserFooterComponent} from './components/footer/userFooter.component';
import {UserFormComponent} from './components/user/user-form.component';
import {BlogFormComponent} from './components/blog/blog-form.component';
import {CourseFormComponent} from './components/course/course-form.component';
import {CourseDetailsComponent} from './components/course/course-details.component';
import {UserStudentListComponent} from './components/user/user-student-list.component';
import {UserInstructorListComponent} from './components/user/user-instructor-list.component';
import {CourseListComponent} from './components/course/course-list-component';
import {LoginComponent} from './components/login/login.component';
import {Error404Component} from './components/error/error404.component';
import {LoginErrorComponent} from './components/error/loginError.component';
import {ErrorComponent} from './components/error/error.component';
import { BarChartComponent } from './components/barChart/barChart.component';
import { UsersDeleteComponent } from './components/user/users-delete.component';
import {UserStudentCommentComponent} from './components/user-student/user-student-comment.component';
import {AdminAddToCourseComponent} from './components/user-admin/user-admin-add.component';
//import { BarChartComponent } from './components/barChart/barChart.component';

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
    path: 'user-footer', component: UserFooterComponent,
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
  },
  {
    path: 'user-form', component: UserFormComponent,
  },
  {
    path: 'blog-form', component: BlogFormComponent,
  },
  {
    path: 'course-form', component: CourseFormComponent,
  },
  {
    path: 'course-details', component: CourseDetailsComponent,
  },
  {
    path: 'user-delete', component: UsersDeleteComponent,
  },
  {
    path: 'user-student-list', component: UserStudentListComponent,
  },
  {
    path: 'course-list', component: CourseListComponent,
  },
  {
    path: 'user-instructor-list', component: UserInstructorListComponent,
  },
  { path: '', redirectTo: 'index', pathMatch: 'full' },
  {
    path: 'login', component: LoginComponent,
  },
  {
    path: 'error-404', component: Error404Component,
  },
  {
    path: 'login-error', component: LoginErrorComponent,
  },
  {
    path: 'error', component: ErrorComponent,
  },
  {
    path: 'bar-chart', component: BarChartComponent,
  },
  {
    path: 'comment', component: UserStudentCommentComponent,
  },
  {
    path: 'add-to-course', component: AdminAddToCourseComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
