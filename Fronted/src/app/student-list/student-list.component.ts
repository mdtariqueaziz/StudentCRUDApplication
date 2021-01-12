import { Component, OnInit } from '@angular/core';
import { Student } from 'src/Student';
import { StudentService } from '../student.service';
import { NgbModalConfig, NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { $ } from 'protractor';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
 
  students: Student[] = [];
  constructor(private student_service: StudentService,config: NgbModalConfig, private modalService: NgbModal,private router: Router) { 
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
   this.loadData();
  }
loadData() {
  this.student_service.getAll().subscribe(data=>{
    this.students = data;
});
}
closeResult!: string;
  
deleted = false;
delete(id: number): void{
  if(confirm('Are you sure you want to delete this record ?')){
    this.student_service.deleteStudent(id).subscribe(data=>{
    console.log(data);
    this.loadData();
    this.deleted = true; 
  })
 }
}
open(content: any) {
  this.modalService.open(content);
}
updated = false;
  updateStudent(student: Student): void{
    console.log("Student = " + student);
    this.student_service.updateStudent2(student).subscribe(response=>{
      console.log(response);
      this.updated = true;
      this.loadData();
    })
  }
}


