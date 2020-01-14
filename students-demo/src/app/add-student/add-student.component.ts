import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import {FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import {StudentsService} from "../services/students.service";
import {ApartmentService} from "../services/apartment.service";
import {Apartment} from "../models/apartment";


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.scss'],
})
export class AddStudentComponent implements OnInit {
<<<<<<< HEAD

  form: FormGroup;
  apartments: Apartment[];



=======
  newStudentForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl('', Validators.email),
    telephone: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
  });
>>>>>>> security

  constructor(
    private studentService: StudentsService,
    private toastr: ToastrService,
    private apartmentService: ApartmentService,
    private fb: FormBuilder
  ) {
    this.createForm();
  }
  createForm() {
    this.form = this.fb.group({
      firstName:  ['',Validators.required],
      lastName:   ['',Validators.required],
      email:      ['',Validators.email],
      telephone:  ['',Validators.required],
      login:      ['',Validators.required],
      password:   ['',Validators.required],
      apartment: [this.apartments, Validators.required],
    });

  }

  ngOnInit() {
    this.apartmentService.getApartments().subscribe(response => {
      this.apartments = response;
    });
  }

  // Metoda do zapisywania Studenta. Jeśli pola spełniaja warunki walidacji zostanie wywołana metoda z studentService zapisująca studenta.
  // Komponent Toastr jest odpowiedzialny za wyświetlenie aletru informującego o przebiegu zleconej operacji
  // https://www.npmjs.com/package/ngx-toastr

  onSubmit() {
    if (!this.form.valid) {
      return false;
    }
    this.studentService.saveStudent(this.form.value).subscribe(
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
    return this.form.get(controlName).hasError;
  }

  // Metoda potrzebna dla wykorzystania Validators.email
  get email() {
    return this.form.get('email');
  }
}
