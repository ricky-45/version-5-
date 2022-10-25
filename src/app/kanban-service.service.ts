import { Injectable } from '@angular/core';
import {User} from './user';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { getNumberOfCurrencyDigits } from '@angular/common';
import { AuthGuard } from './shared/auth.guard';
import {Status} from './status';
import { Candidate } from './candidate';
import {CustomTag} from './custom-tag';




@Injectable({
  providedIn: 'root'
})
export class KanbanServiceService  {

  status="";
  
  searchObject:any;

  object:any;
  constructor(private _http:HttpClient) { }

  public logInUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>('http://localhost:8090/login',user)
  }

  public registerUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8090/register",user)
  }

  public getDataFromBackend(data:any):Observable<any>{
    return this._http.post<any>("http://localhost:8090/getData",data);
  }

  public updateStatus(status:Status){
    return this._http.put<any>("http://localhost:8090/updateData",status);
  }

  public updateCustomTags(obj:CustomTag){

    console.log("uodate custom service hit")

    console.log(obj.value)

    console.log(obj)

    return this._http.put<any>("http://localhost:8080/updateCustomTags",obj)

  }

  public storeObj(searchObj:any){

    this.searchObject=searchObj;

}

 
  public searchData(searchObj:any){

    searchObj=this.searchObject;

    console.log(searchObj)

    console.log("search data service hit")

    return this._http.post<any>("http://localhost:8090/searchData",searchObj)

  }

  public sendObject(obj:any){
    this.object=obj;
    console.log(obj.candidateId)
    

  }


  public giveDatatoModal(obj:any):Observable<any>{
    obj=this.object;
    console.log("giveDataTOModal activated")
    console.log(obj)
    return this._http.post<any>("http://localhost:8090/getObj",obj)
  }

  uploadingImage(imageFormData:any):Observable<any>{
    return this._http.post<any>("http://localhost:8090/upload/image/",imageFormData);
  }


  viewingImage(image:any){
    return this._http.get<any>("http://localhost:8090/get/image/info/"+image);
  }

  public statusReceived(status:string){
    if(status==="ok"){
      this.status="ok";
      return "ok";
    }
    else{
      console.log("notok hit")
      this.status=="notok"
      return "notok";
    }
    
  }
  
  public registerCandidateFromRemote(candidate:Candidate):Observable<any>{

    return this._http.post<any>("http://localhost:8090/registerCandidate",candidate);

  }

  public statusSend(value:String){
    if(this.status=="ok"){
      value="ok"
      return value;
    }
    else{
      value="notok"
      return value;
    }
  }
}
