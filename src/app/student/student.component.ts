import { Component,OnInit } from '@angular/core';
import { Student } from '../pojo/Student';
import { StudentServiceService } from '../Service/student-service.service';
import { Options } from '../Service/student-service.service';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students:any=[];
  studObj:Student= new Student();
  options:Options=new Options();
  constructor( private studentService:StudentServiceService){

  }
  ngOnInit():void
  {

    this.fillList();
 //   this.studentService.getData().subscribe(data=>{this.students=data; alert(JSON.stringify(this.students));});
  }
  fillList()
  {
    this.studentService.getData("students",this.options).subscribe(data=>{this.students=data; alert(JSON.stringify(this.students));});
    this.clearData();
  }
  clearData()
  {
    this.studObj.sno=0;
    this.studObj.sname="";
    this.studObj.age=0;
  }

  save()
  {
    this.studentService.insertData("students",this.studObj,this.options).subscribe(data=>{this.fillList();});
  }
  update(sno:number)
  {
    alert(sno);
    this.studentService.getData("students/"+sno,this.options).subscribe(data=>{this.studObj=data;});
  }
  edit()
  {
    this.studentService.updateData("students",this.studObj,this.options).subscribe(data=>{this.fillList();}); 
  }

  delete(sno:number)
  {
    //alert(sno);
    let ans= confirm("Are you sure you want to delete this Record?");
    if(ans)
    this.studentService.deleteData("students/"+sno,this.options).subscribe(data=>{this.fillList();});
  }

}
