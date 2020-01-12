import { AddStudentComponent } from './add-student/add-student.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { BillsComponent } from './list-bill/bills.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {AddBillComponent} from './add-bill/add-bill.component';
import {LoginComponent} from './login/login.component';

// Delkaracja na jakim url ma się wyrenderować jaki komponent. Pojawi się w miejscu deklaracji <router-outlet>
const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'enrolment', component: AddStudentComponent },
  { path: 'addBill', component: AddBillComponent},
  { path: 'allBills', component: BillsComponent},
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
