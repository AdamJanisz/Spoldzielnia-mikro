import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { StudentsService } from '../services/students.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {ApiService} from '../core/api.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.scss']
})
export class AddStudentComponent implements OnInit {
  newStudentForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl('', Validators.email),
    telephone: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(
    private studentService: StudentsService,
    private toastr: ToastrService
  ) {}

  ngOnInit() {}

  // Metoda do zapisywania Studenta. Jeśli pola spełniaja warunki walidacji zostanie wywołana metoda z studentService zapisująca studenta.
  // Komponent Toastr jest odpowiedzialny za wyświetlenie aletru informującego o przebiegu zleconej operacji
  // https://www.npmjs.com/package/ngx-toastr

  onSubmit() {
    if (!this.newStudentForm.valid) {
      return false;
    }
    this.studentService.saveStudent(this.newStudentForm.value).subscribe(
      data => {
        this.toastr.success('Sukces!', 'Student dodany prawidłowo');
      },
      error => {
        this.toastr.error('Błąd!', 'Student niedodany prawidłowo');
        console.log('Coś poszło nie tak !', error);
      }
    );
  }

  // Metoda do weryfikowania czy pole spełnia warunki walidacji
  hasError(controlName) {
    return this.newStudentForm.get(controlName).hasError;
  }

  // Metoda potrzebna dla wykorzystania Validators.email
  get email() {
    return this.newStudentForm.get('email');
  }
}
