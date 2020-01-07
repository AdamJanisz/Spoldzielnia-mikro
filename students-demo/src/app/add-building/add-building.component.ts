import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import {FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';
import {BuildingService} from "../services/building.service";
import {StudentsService} from "../services/students.service";
import {Student} from "../models/student";

@Component({
  selector: 'app-add-building',
  templateUrl: './add-building.component.html',
  styleUrls: ['./add-building.component.scss']
})
export class AddBuildingComponent implements OnInit {

  form: FormGroup;
  students: Student[];

  constructor(
    private buildingService: BuildingService,
    private studentService: StudentsService,
    private toastr: ToastrService,
    private fb: FormBuilder
  ) {
    this.createForm();
  }
  createForm() {
    this.form = this.fb.group({
      city:  ['',Validators.required],
      street:   ['',Validators.required],
      buildingNumber:      ['',Validators.required],
      electricityPrice:  ['',Validators.required],
      hotWaterPrice:      ['',Validators.required],
      coldWaterPrice:   ['',Validators.required],
      sewagePrice: ['', Validators.required],
      maintenanceFundPrice:   ['',Validators.required],
      owner: [this.students, Validators.required],
    });
  }

  ngOnInit() {
    this.studentService.getStudents().subscribe(response => {
      this.students = response;
    });
  }

  // Metoda do zapisywania Studenta. Jeśli pola spełniaja warunki walidacji zostanie wywołana metoda z studentService zapisująca studenta.
  // Komponent Toastr jest odpowiedzialny za wyświetlenie aletru informującego o przebiegu zleconej operacji
  // https://www.npmjs.com/package/ngx-toastr

  onSubmit() {
    if (!this.form.valid) {
      return false;
    }
    this.buildingService.saveBuilding(this.form.value).subscribe(
      data => {
        this.toastr.success('Sukces!', 'Budynek dodany prawidłowo');
      },
      error => {
        this.toastr.error('Błąd!', 'Budynek niedodany prawidłowo');
        console.log('Coś poszło nie tak !', error);
      }
    );
  }

  // Metoda do weryfikowania czy pole spełnia warunki walidacji
  hasError(controlName) {
    return this.form.get(controlName).hasError;
  }
}
