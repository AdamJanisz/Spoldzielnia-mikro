import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private http: HttpClient) { }

  title = 'students-demo';
  myFunc(){
    localStorage.removeItem('currentUser');
    document.getElementById('userLoginInfoName').innerText = '';
    document.getElementById('logoutInfo').innerText = '';

    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    window.sessionStorage.removeItem('token');
    return this.http.post('http://localhost:8080/logout/', {headers: reqHeader});
  }
}




