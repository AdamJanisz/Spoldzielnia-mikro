import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Building} from "../models/building";
import {ApartmentService} from "../services/apartment.service";
import {BuildingService} from "../services/building.service";
import {MatTableDataSource} from "@angular/material";


@Component({
  selector: 'app-add-apartment',
  templateUrl: './add-apartment.component.html',
  styleUrls: ['./add-apartment.component.scss']
})



export class AddApartmentComponent implements OnInit {


  form: FormGroup;
  buildings: Building[];
  displayedColumns: string[] = ['city','street','buildingNumber','apartmentNumber'];
  dataSource;

  constructor(
    private fb: FormBuilder,
    private apartmentService: ApartmentService,
    private buildingService: BuildingService,
    private toastr: ToastrService
  ) {this.createForm();}

  createForm() {
    this.form = this.fb.group({
      apartmentNumber: ['', Validators.required],
      apartmentAddress: [this.buildings, Validators.required]
    });

  }

  ngOnInit() {
  this.buildingService.getBuildings().subscribe(response => {
  this.buildings = response;
});

  this.apartmentService.getApartments().subscribe(response =>{
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

    this.apartmentService.saveApartment(this.form.value).subscribe(
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
