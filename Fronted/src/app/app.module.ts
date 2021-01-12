import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Router, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    AddstudentComponent,  
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot([{path:'',component: StudentListComponent},
                          {path:'add-student/:id',component: AddstudentComponent},
                          {path:'add-student',component:AddstudentComponent},
                         
  ]),
    NgbModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
