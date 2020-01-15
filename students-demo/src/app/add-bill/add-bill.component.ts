import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { BillService } from '../services/bill.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import {MatTableDataSource} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {Bill} from "../models/bill";

import {ApiService} from "../core/api.service";
import get = Reflect.get;


@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.scss']
})
export class AddBillComponent implements OnInit {


  newBillForm = new FormGroup({

    id: new FormControl(''),
    electricity: new FormControl(''),
    hotWater: new FormControl(''),
    coldWater: new FormControl(''),
    sewage: new FormControl(''),
    maintenanceFund: new FormControl(''),

  });

  constructor(
    private billService: BillService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(parameterMap => {
      const id = +parameterMap.get('id');

      this.billService.getBill(id.toString()).forEach(value => this.newBillForm.setControl('id', new FormControl(value.id)));
      this.billService.getBill(id.toString()).forEach(value => this.newBillForm.setControl('electricity', new FormControl(value.electricity)));
      this.billService.getBill(id.toString()).forEach(value => this.newBillForm.setControl('hotWater', new FormControl(value.hotWater)));
      this.billService.getBill(id.toString()).forEach(value => this.newBillForm.setControl('coldWater', new FormControl(value.coldWater)));
      this.billService.getBill(id.toString()).forEach(value => this.newBillForm.setControl('sewage', new FormControl(value.sewage)));
      this.billService.getBill(id.toString()).forEach(value => this.newBillForm.setControl('maintenanceFund', new FormControl(value.maintenanceFund)));

    });
  }


  // Metoda do zapisywania Studenta. Jeśli pola spełniaja warunki walidacji zostanie wywołana metoda z studentService zapisująca studenta.
  // Komponent Toastr jest odpowiedzialny za wyświetlenie aletru informującego o przebiegu zleconej operacji
  // https://www.npmjs.com/package/ngx-toastr


  onSubmit() {
    if (!this.newBillForm.valid) {
      return false;
    }
    this.billService.updateBill(this.newBillForm.value).subscribe(
      data => {
        this.toastr.success('Sukces!', 'Rachunek edytowany prawidłowo');
      },
      error => {
        this.toastr.error('Błąd!', 'Rachunek edytowany prawidłowo');
      });

    // Metoda do weryfikowania czy pole spełnia warunki walidacji
    /*     hasError(controlName) {
           return this.newBillForm.get(controlName).hasError;
         }

         // Metoda potrzebna dla wykorzystania Validators.email
         get email() {
           return this.newBillForm.get('email');
         }*/
  }

}
