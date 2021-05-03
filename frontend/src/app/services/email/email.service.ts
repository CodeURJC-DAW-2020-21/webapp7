import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

const BASE_URL =  '/api/email/';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(private httpClient: HttpClient) {
  }

  addEmail(nombre: string, email: string, asunto: string, contenido: string): Observable<String>{
    return this.httpClient.post(BASE_URL, {nombre, email,asunto,contenido}).pipe(
    ) as Observable<String>;
  }
}
