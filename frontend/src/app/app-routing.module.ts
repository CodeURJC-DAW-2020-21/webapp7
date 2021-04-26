import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent} from './components/index/index.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';



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

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
