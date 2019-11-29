import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/student';
import { environment } from '../../environments/environment';
import {__param} from "tslib";
import {Params} from "@angular/router";

// Zastosowanie serwisów jest ogromne. W naszym przypadku
// zawiera logikę związaną z interakcją z zewnętrznym API.

@Injectable({
  providedIn: 'root'
})
export class StudentsService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_STUDENTS = environment.API_URL_STUDENTS;

  // W konstruktorze wstrzykiwany jest klient http
  constructor(private httpClient: HttpClient) { }


  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getStudents(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.API_URL_STUDENTS);
  }
  deleteStudent(id : number): Observable<Student[]> {
     this.httpClient.delete(this.API_URL_STUDENTS+'/?id=1');
    return this.httpClient.get<Student[]>(this.API_URL_STUDENTS);
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api
  saveStudent(student: Student): Observable<Student> {
    return this.httpClient.post(this.API_URL_STUDENTS, student);
  }
}
