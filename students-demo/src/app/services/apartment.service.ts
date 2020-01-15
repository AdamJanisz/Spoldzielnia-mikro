import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

import {Student} from "../models/student";
import {Apartment} from "../models/apartment";

@Injectable({
  providedIn: 'root'
})
export class ApartmentService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_APARTMENT = environment.API_URL_APARTMENTS;
  API_URL_LOGGEDAPARTMENT = environment.API_URL_LOGGEDAPARTMENT;

  // W konstruktorze wstrzykiwany jest klient http
  constructor(private httpClient: HttpClient,private router: Router) { }



  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getApartment(id: String): Observable<Apartment> {
    return this.httpClient.get(this.API_URL_APARTMENT+id);
  }

  getLoggedApartment(username: string): Observable<Apartment[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    return this.httpClient.get<Apartment[]>(this.API_URL_LOGGEDAPARTMENT + username,{headers: reqHeader});
  }
  getApartments(): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(this.API_URL_APARTMENT);
  }
  getBuildingApartments(buildingId: string): Observable<Apartment[]> {
    return this.httpClient.get<Apartment[]>(this.API_URL_APARTMENT+"/building/"+buildingId);
  }
  editApartment(id : String) {
    this.router.navigate(['editApartment/',id])
  }

  saveApartment(apartment: Apartment): Observable<Apartment> {
    return this.httpClient.post(this.API_URL_APARTMENT, apartment);
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api

}
