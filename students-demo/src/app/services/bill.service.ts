import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Bill} from '../models/bill';
import {environment} from '../../environments/environment';


// Zastosowanie serwisów jest ogromne. W naszym przypadku
// zawiera logikę związaną z interakcją z zewnętrznym API.

@Injectable({
  providedIn: 'root'
})
export class BillService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_BILLS = environment.API_URL_BILLS;

  // W konstruktorze wstrzykiwany jest klient http
  constructor(private httpClient: HttpClient) {
  }


  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getBills(): Observable<Bill[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS, {headers: reqHeader});
  }

  deleteBill(id: number): Observable<Bill[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    this.httpClient.delete(this.API_URL_BILLS + '?id=' + id, {headers: reqHeader}).subscribe(data => {
    });
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS, {headers: reqHeader});
  }

  saveBill(bill: Bill): Observable<Bill> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    return this.httpClient.post(this.API_URL_BILLS, bill, {headers: reqHeader});
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api

}
