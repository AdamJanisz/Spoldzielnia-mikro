import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../models/student';
import {environment} from '../../environments/environment';
import {__param} from 'tslib';
import {Params} from '@angular/router';
import {AppUserRole} from '../models/AppUserRole';

// Zastosowanie serwisów jest ogromne. W naszym przypadku
// zawiera logikę związaną z interakcją z zewnętrznym API.

@Injectable({
  providedIn: 'root'
})
export class StudentsService {
  // Pobieranie z environment zmiennej środowiskowej reprezentującej url do serwisu studentów za pośrednictwem gateway
  API_URL_STUDENTS = environment.API_URL_STUDENTS;
<<<<<<< HEAD
  API_URL_APARTMENT = environment.API_URL_APARTMENTS;

=======
  API_URL_REGISTER = environment.API_URL_REGISTER;
  private currentUser: any;
>>>>>>> security
  // W konstruktorze wstrzykiwany jest klient http
  constructor(private httpClient: HttpClient) {
  }

  // Metoda pobierająca liste studentów z studentService za pomocą endpointa /api/students (GET)
  // Observable<Student[]> - To strumień który nasłuchuje na tablice studentów
  // Za pomocą httpClient odpytywany jest StudentService
  getStudents(): Observable<Student[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    console.log(JSON.parse(window.sessionStorage.getItem('token')).access_token);
    return this.httpClient.get<Student[]>(this.API_URL_STUDENTS, {headers: reqHeader});
  }
<<<<<<< HEAD
  deleteStudent(id : number): Observable<Student[]> {
    this.httpClient.delete(this.API_URL_STUDENTS+id).subscribe(data=>{});
   return this.httpClient.get<Student[]>(this.API_URL_STUDENTS);
=======
  deleteStudent(id: number): Observable<Student[]> {
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    this.httpClient.delete(this.API_URL_STUDENTS + '?id=' + id, {headers: reqHeader}).subscribe(data => {
    });
    return this.httpClient.get<Student[]>(this.API_URL_STUDENTS, {headers: reqHeader});
>>>>>>> security
  }

  // Metoda wywołująca endpoint /api/students (POST)
  // Dodanie studenta w StudentService za pośrednictwem wywołania metody w Rest Api
  saveStudent(student: Student): Observable<Student> {
<<<<<<< HEAD
    var temp=this.httpClient.post(this.API_URL_STUDENTS, student);

   //  this.httpClient.post(this.API_URL_APARTMENT+student.apartment.id+"/tenant/"+student.id,student.apartment);
    return temp;
=======

    return this.httpClient.post(this.API_URL_REGISTER , student);
>>>>>>> security
  }


  updateCurrentUserRoles(username: string)  {
    return this.httpClient.get<AppUserRole[]>(this.API_URL_STUDENTS + 'getUser/' + username );
  }

}
