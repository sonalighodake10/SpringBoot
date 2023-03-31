import { Component, OnInit } from '@angular/core';
import { Options, StudentServiceService } from '../Service/student-service.service';
import{ Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit{

  ngOnInit(): void {
    
  }
  login:Login= new Login();

  constructor(private http:StudentServiceService,private router:Router)
  {

  }
  loginMeth()
  {
    let var1:any=null;
    this.http.insertData("login",this.login,var1).subscribe(data=>{
      alert(JSON.stringify(data));
      const accessToken=data['accessToken'];
      const userType=data['userType'];
      const orgName=data['orgName'];
      const userName=data['name'];

      if(userType=="Not Found")
         alert("Invalid UserID Or Password");
         else{
          sessionStorage.setItem('access-token',accessToken);
          sessionStorage.setItem('userType',userType);
          sessionStorage.setItem('orgName',orgName);
          sessionStorage.setItem('userName',userName);
          this.router.navigateByUrl('/studpath');
         }
    });
  }
}
  export class Login{
    userName:string="";
    password:string="";

  }