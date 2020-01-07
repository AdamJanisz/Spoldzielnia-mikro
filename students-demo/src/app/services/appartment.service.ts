import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {Appartment} from "../models/appartment";
import {Student} from "../models/student";

@Injectable({
  providedIn: 'root'
})
export class AppartmentService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_APPARTMENT = environment.API_URL_APPARTMENTS;

  // W konstruktorze wstrzykiwany jest klient http
  constructor(private httpClient: HttpClient,private router: Router) { }



  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getAppartment(id: String): Observable<Appartment> {
    return this.httpClient.get(this.API_URL_APPARTMENT+id);
  }
  getAppartments(): Observable<Appartment[]> {
    return this.httpClient.get<Appartment[]>(this.API_URL_APPARTMENT);
  }
  getBuildingAppartments(buildingId: string): Observable<Appartment[]> {
    return this.httpClient.get<Appartment[]>(this.API_URL_APPARTMENT+"/building/"+buildingId);
  }
  editAppartment(id : String) {
    this.router.navigate(['editAppartment/',id])
  }

  updateAppartment(appartment: Appartment): Observable<Appartment> {
    return this.httpClient.put(this.API_URL_APPARTMENT, appartment);
  }
  saveAppartment(appartment: Appartment): Observable<Appartment> {
    return this.httpClient.post(this.API_URL_APPARTMENT+"build/"+appartment.appartmentAddress.id, appartment);
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api

}
