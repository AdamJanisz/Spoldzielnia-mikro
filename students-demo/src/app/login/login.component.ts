import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ApiService} from '../core/api.service';
import {HttpParams} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [ApiService]
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidLogin = false;
  currentUser: string;

  constructor(private formBuilder: FormBuilder, private router: Router, private apiService: ApiService) {
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const body = new HttpParams()
      .set('username', this.loginForm.controls.username.value)
      .set('password', this.loginForm.controls.password.value)
      .set('grant_type', 'password');

    this.apiService.login(body.toString()).subscribe(data => {
      window.sessionStorage.setItem('token', JSON.stringify(data));
      console.log(window.sessionStorage.getItem('token'));
      localStorage.setItem('currentUser', body.get('username'));
      document.getElementById('userLoginInfoName').innerText = 'Zalogowany jako:' + body.get('username');
      document.getElementById('logoutInfo').innerText = 'Wyloguj';
      this.router.navigate(['successLogin']);
    }, error => {
      alert(error.error.error_description);
    });
  }

  ngOnInit() {
    window.sessionStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });

    this.currentUser = this.readLocalStorageValue('currentUser');
  }

  readLocalStorageValue(key: string): string {
    return localStorage.getItem(key);
  }


}
