import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Student } from 'src/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private studentUrl!: string;


  constructor(private http: HttpClient) { 
    this.studentUrl = 'http://localhost:4500/api/students';

  }
  student!: Student;
  getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentUrl);
  }
  saveStudent(student: any) {
    return this.http.post<any>(this.studentUrl, student);
  }

  updateStudent2(student: any) {
    return this.http.put<any>(this.studentUrl, student);
  }

  deleteStudent(id: number) {
    return this.http.delete<Student>(this.studentUrl + "/" + id);
  }
  getStudent(id: number) {
    return this.http.get<Student>(this.studentUrl + "/" + id );
 }
 
 updateStudent(id: any, data: any): Observable<Object> {  
  return this.http.put(this.studentUrl + "/" +id,data);  
}  

 setter(student: Student) {
   this.student = student;
 }
getter() {
  return this.student ;
}
sub = new Subject();

}
