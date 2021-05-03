import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { EmailService } from 'src/app/services/email/email.service';

const BASE_URL = '/api/email/';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['../../../assets/css/style.css']
})

export class ContactComponent implements OnInit {

  constructor(
    private router: Router,
    activatedRoute: ActivatedRoute,
    private http: HttpClient,
    private emailService: EmailService) {
  }

  ngOnInit(): void {
  }

  createEmail(event: any, nombre: string, email: string, asunto: string, contenido: string) {
    event.preventDefault();
    this.emailService.addEmail(nombre, email,asunto,contenido).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }

}
