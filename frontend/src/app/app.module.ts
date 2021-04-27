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


@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    HeaderComponent,
    FooterComponent,
    UserInstructorComponent,
    AboutComponent,
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
