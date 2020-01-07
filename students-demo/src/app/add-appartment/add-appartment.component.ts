import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Building} from "../models/building";
import {AppartmentService} from "../services/appartment.service";
import {BuildingService} from "../services/building.service";
import {MatTableDataSource} from "@angular/material";


@Component({
  selector: 'app-add-apartment',
  templateUrl: './add-appartment.component.html',
  styleUrls: ['./add-appartment.component.scss']
})

/*  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ];*/


export class AddAppartmentComponent implements OnInit {

   // appartmentAddress: Building[] = [],
  form: FormGroup;
  buildings: Building[];
  displayedColumns: string[] = ['city','street','buildingNumber','appartmentNumber'];
  dataSource;

  constructor(
    private fb: FormBuilder,
    private appartmentService: AppartmentService,
    private buildingService: BuildingService,
    private toastr: ToastrService
  ) {this.createForm();}

  createForm() {
    this.form = this.fb.group({
      appartmentNumber: ['', Validators.required],
      appartmentAddress: [this.buildings, Validators.required]
    });

  }

  ngOnInit() {
  this.buildingService.getBuildings().subscribe(response => {
  this.buildings = response;
});

  this.appartmentService.getAppartments().subscribe(response =>{
    this.dataSource = new MatTableDataSource(response);
  });

  }
  // Filtrowanie rekordów w tabeli
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  // Metoda do zapisywania Studenta. Jeśli pola spełniaja warunki walidacji zostanie wywołana metoda z studentService zapisująca studenta.
  // Komponent Toastr jest odpowiedzialny za wyświetlenie aletru informującego o przebiegu zleconej operacji
  // https://www.npmjs.com/package/ngx-toastr

  onSubmit() {

    this.appartmentService.saveAppartment(this.form.value).subscribe(
      data => {
        this.toastr.success('Sukces!', 'Lokal dodany prawidłowo');
      },
      error => {
        this.toastr.error('Błąd!', 'Lokal niedodany prawidłowo');
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
