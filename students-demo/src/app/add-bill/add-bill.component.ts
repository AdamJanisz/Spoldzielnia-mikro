import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { BillService } from '../services/bill.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {ApiService} from '../core/api.service';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.scss']
})
export class AddBillComponent implements OnInit {
  newBillForm = new FormGroup({
    electricity: new FormControl(''),
    hotWater: new FormControl(''),
    coldWater: new FormControl(''),
    sewage: new FormControl(''),
    repairFund: new FormControl(''),

  });

  constructor(
    private apiService: ApiService,
    private billService: BillService,
    private toastr: ToastrService
  ) {}

  ngOnInit() {}

  // Metoda do zapisywania Studenta. Jeśli pola spełniaja warunki walidacji zostanie wywołana metoda z studentService zapisująca studenta.
  // Komponent Toastr jest odpowiedzialny za wyświetlenie aletru informującego o przebiegu zleconej operacji
  // https://www.npmjs.com/package/ngx-toastr

  onSubmit() {
    if (!this.newBillForm.valid) {
      return false;
    }
    this.billService.saveBill(this.newBillForm.value).subscribe(
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
    return this.newBillForm.get(controlName).hasError;
  }

  // Metoda potrzebna dla wykorzystania Validators.email
  get email() {
    return this.newBillForm.get('email');
  }
}
