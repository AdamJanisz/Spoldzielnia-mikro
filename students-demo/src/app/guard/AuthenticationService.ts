// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { BehaviorSubject, Observable } from 'rxjs';
// import { map } from 'rxjs/operators';
//
// import { Student } from '../models/student';
//
// @Injectable({ providedIn: 'root' })
// export class AuthenticationService {
//   private currentUserSubject: BehaviorSubject<Student>;
//   public currentUser: Observable<Student>;
//
//   constructor(private http: HttpClient) {
//     this.currentUserSubject = new BehaviorSubject<Student>(JSON.parse(localStorage.getItem('currentUser')));
//     this.currentUser = this.currentUserSubject.asObservable();
//   }
//
//   public get currentUserValue(): Student {
//     return this.currentUserSubject.value;
//   }
//
//   login(username: string, password: string) {
//     return this.http.post<any>(`${config.apiUrl}/users/authenticate`, { username, password })
//       .pipe(map(user => {
//         // login successful if there's a jwt token in the response
//         if (user && user.token) {
//           // store user details and jwt token in local storage to keep user logged in between page refreshes
//           localStorage.setItem('currentUser', JSON.stringify(user));
//           this.currentUserSubject.next(user);
//         }
//
//         return user;
//       }));
//   }
//
//   logout() {
//     // remove user from local storage to log user out
//     localStorage.removeItem('currentUser');
//     this.currentUserSubject.next(null);
//   }
// }
