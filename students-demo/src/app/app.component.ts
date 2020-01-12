import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {StudentsService} from "./services/students.service";
import {AppUserRole} from "./models/AppUserRole";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  constructor(private http: HttpClient, private userService: StudentsService) {
  }

  appuserroles: string[] = [];
  anonymous: boolean;
  iterator = 0;
  title = 'students-demo';

  myFunc() {
    this.appuserroles[0] = '';
    this.anonymous = true;
    localStorage.removeItem('currentUser');
    document.getElementById('userLoginInfoName').innerText = '';
    document.getElementById('logoutInfo').innerText = '';
    const reqHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + JSON.parse(window.sessionStorage.getItem('token')).access_token
    });
    window.sessionStorage.removeItem('token');
    window.sessionStorage.removeItem('username');
    return this.http.post('http://localhost:8080/logout/', {headers: reqHeader});
  }

  ngOnInit(): void {
    this.anonymous = true;
    this.appuserroles[0] = null;
    console.log(window.sessionStorage.getItem('username'));
    if (window.sessionStorage.getItem('username')) {
      document.getElementById('userLoginInfoName').innerText = 'Zalogowany jako:' + window.sessionStorage.getItem('username');
      document.getElementById('logoutInfo').innerText = 'Wyloguj';
      this.userService.updateCurrentUserRoles(window.sessionStorage.getItem('username')).subscribe(appuserroles =>
        appuserroles.forEach(appuserrole => {
          this.appuserroles[0] = appuserrole.role;
          this.iterator++;
          if (this.appuserroles[0] != null) {
            this.anonymous = false;
          }
        }));


    }
  }
}



