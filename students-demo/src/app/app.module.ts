import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentsComponent } from './students/students.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HttpClientModule } from '@angular/common/http';
import { AddStudentComponent } from './add-student/add-student.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import {AddBillComponent} from "./add-bill/add-bill.component";
import {BillsComponent} from "./list-bill/bills.component";
import {BuildingsComponent} from "./building-list/buildings.component";
import {AddApartmentComponent} from "./add-appartment/add-apartment.component";
import {MatSelectModule} from "@angular/material";
import {AddBuildingComponent} from "./add-building/add-building.component";
=======
import {AddBillComponent} from './add-bill/add-bill.component';
import {BillsComponent} from './list-bill/bills.component';
import {LoginComponent} from './login/login.component';
>>>>>>> security

// Klasa w której deklaruję się komponenty i importuję się moduły.

@NgModule({
  declarations: [
    LoginComponent,
    AppComponent,
    StudentsComponent,
    AddStudentComponent,
    DashboardComponent,
    AddBillComponent,
<<<<<<< HEAD
    BillsComponent,
    BuildingsComponent,
    AddApartmentComponent,
    AddBuildingComponent
=======
    BillsComponent
>>>>>>> security
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
