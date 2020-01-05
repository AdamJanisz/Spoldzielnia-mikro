import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  title = 'students-demo';
  myFunc(){
    localStorage.removeItem('currentUser');
    document.getElementById('userLoginInfoName').innerText = '';
    document.getElementById('logoutInfo').innerText = '';

  }
}




