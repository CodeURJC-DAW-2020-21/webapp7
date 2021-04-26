import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent} from './components/index/index.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {AboutComponent} from './components/about/about.component';


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
  path: 'blogSingle', component: BlogSingle2Component,
  },
  {
  path: 'blogSingle3', component: BlogSingle2Component,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
