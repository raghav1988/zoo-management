import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ZooserviceService {

  constructor(private http: HttpClient) { }

  getAllAnimals(){
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.http.get<any>("http://localhost:8080/api/zoo", { headers, responseType: 'text' as 'json' });
  }

  geAnimalByID(id){
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    const url = "http://localhost:8080/api/zoo/"+id+"/animal";
    return this.http.get<any>(url, { headers, responseType: 'text' as 'json' });

  }
}
