
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bill } from '../models/bill';
import { environment } from '../../environments/environment';
import {__param} from "tslib";
import {ActivatedRoute, Params, Route, Router} from "@angular/router";


// Zastosowanie serwisów jest ogromne. W naszym przypadku
// zawiera logikę związaną z interakcją z zewnętrznym API.

@Injectable({
  providedIn: 'root'
})
export class BillService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_BILLS = environment.API_URL_BILLS;

  // W konstruktorze wstrzykiwany jest klient http

  constructor(private httpClient: HttpClient, private router: Router) { }
  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService

  getBill(billId: String): Observable<Bill> {
    return this.httpClient.get(this.API_URL_BILLS+billId);
  }
  getAllBills(): Observable<Bill[]> {
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS);
  }
  getBills(appartmentId: number): Observable<Bill[]> {
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS + 'appartment/' + appartmentId);
  }
  editBill(id : String) {
    this.router.navigate(['editBill/',id]);
  }

  updateBill(bill: Bill): Observable<Bill> {
    return this.httpClient.put(this.API_URL_BILLS, bill);
  }


  /*getBills(): Observable<Bill[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS, {headers: reqHeader});
  }*/

/*  deleteBill(id: number): Observable<Bill[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    this.httpClient.delete(this.API_URL_BILLS + '?id=' + id, {headers: reqHeader}).subscribe(data => {
    });
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS, {headers: reqHeader});
  }*/

/*  saveBill(bill: Bill): Observable<Bill> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    return this.httpClient.post(this.API_URL_BILLS, bill, {headers: reqHeader});
  }*/

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api
}
