import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {Building} from "../models/building";

@Injectable({
  providedIn: 'root'
})
export class BuildingService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_BUILDING = environment.API_URL_BUILDINGS;

  // W konstruktorze wstrzykiwany jest klient http
  constructor(private httpClient: HttpClient,private router: Router) { }



  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getBuilding(id: String): Observable<Building> {
    return this.httpClient.get(this.API_URL_BUILDING+id);
  }
  getBuildings(): Observable<Building[]> {
    return this.httpClient.get<Building[]>(this.API_URL_BUILDING);
  }
  editBuilding(id : String) {
    this.router.navigate(['editBuilding/',id]);
  }
  saveBuilding(building : Building): Observable<Building> {
    return this.httpClient.post(this.API_URL_BUILDING,building);
  }
  updateBuilding(building: Building): Observable<Building> {
    return this.httpClient.put(this.API_URL_BUILDING, building);
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api

}
