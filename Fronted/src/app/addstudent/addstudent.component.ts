import { Component, OnInit } from '@angular/core';
import { Student } from 'src/Student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})
export class AddstudentComponent implements OnInit {

  constructor(private student_service: StudentService) { }

  
  student: Student = {
    id: '',
    firstName: '',
    lastName: '',
    email:''
  }
  ngOnInit(): void {
  }
  
  
  submmited = false;
  
  saveStudent(): void{
    console.log(this.student.firstName);
    const data = {
      id: this.student.id,
      firstName: this.student.firstName,
      lastName: this.student.lastName,
      email: this.student.email
    }
      this.student_service.saveStudent(data).subscribe(response=>{
        console.log(response);
        this.submmited = true;    
      })        
  }
  newHero(){
    this.submmited = false;

  }

}
