import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent} from './components/index/index.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {BlogSingle2Component} from "./components/blogSingle2/blogSingle2.component";
import {BlogSingle3Component} from "./components/blogSingle3/blogSingle3.component";


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
    path: 'blogSingle2', component: BlogSingle2Component,
  },
  {
    path: 'blogSingle3', component: BlogSingle3Component,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
