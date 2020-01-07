import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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
  constructor(private httpClient: HttpClient,private router: Router) { }



  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getBill(billId: String): Observable<Bill> {
    return this.httpClient.get(this.API_URL_BILLS+billId);
  }
  getBills(): Observable<Bill[]> {
    return this.httpClient.get<Bill[]>(this.API_URL_BILLS);
  }
  editBill(id : String) {
    this.router.navigate(['editBill/',id])
  }

  updateBill(bill: Bill): Observable<Bill> {
    return this.httpClient.put(this.API_URL_BILLS, bill);
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api

}
