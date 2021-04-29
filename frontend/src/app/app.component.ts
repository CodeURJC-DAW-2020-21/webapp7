import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['../assets/css/style.css']
})
export class AppComponent {
  title = 'frontend';
  constructor(private httpClient: HttpClient) {}
  // search(title: string){
    // this.httpClient.get()
  // }
}
