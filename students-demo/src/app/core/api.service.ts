import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../models/user.model';
import {Observable} from 'rxjs/index';

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  baseUrl = 'http://localhost:8087/sm/';

  login(loginPayload) {
    const headers = {
      Authorization: 'Basic ' + btoa('poli:poli1'),
      'Content-type': 'application/x-www-form-urlencoded'
    };
    return this.http.post('http://localhost:8080/' + 'oauth/token', loginPayload, {headers});
  }

  // getUsers() {
  //   return this.http.get(this.baseUrl + 'appUser?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  // }
  //
  // getUserById(id: number) {
  //   return this.http.get(this.baseUrl + 'appUser/' + id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  // }
  //
  // createUser(user: User) {
  //   return this.http.post(this.baseUrl + 'appUser?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token, user);
  // }
  //
  // updateUser(user: User) {
  //   return this.http.put(this.baseUrl + 'appUser/' + user.id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token, user);
  // }
  //
  // deleteUser(id: number) {
  //   return this.http.delete(this.baseUrl + 'appUser/' + id + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  // }
}
