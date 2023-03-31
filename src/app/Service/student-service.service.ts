import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
path:string="http://localhost:8085/v1/admin/";

  constructor(private httpClient:HttpClient) { }

  getData(url:string,options:Options):Observable<any>{
   options=this.setHeaders(options);
    return this.httpClient.get(this.path+url,options);
  }

  insertData(url:string,obj:any,options:Options):Observable<any>{
    options=this.setHeaders(options);
    return this.httpClient.post(this.path+url,obj,options);
  }

  updateData(url:string,obj:any,options:Options):Observable<any>{
    options=this.setHeaders(options);
    return this.httpClient.put(this.path+url,obj,options);
  }

  deleteData(url:string,options:Options):Observable<any>{
    options=this.setHeaders(options);
    return this.httpClient.delete(this.path+url,options);
  }

  private setHeaders(options:Options)
  {
    if(!options)
     options=new Options();

     if(sessionStorage.getItem('access-token'))
     {
      options.headers['access-token']=sessionStorage.getItem('access-token');

     }
     return options;
  }
}

export class Options{

  params:any;
  headers:any;
  observe:any;
  constructor(){
    this.params={};
    this.headers={};
    this.observe='body';
  }

}
