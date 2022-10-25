import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { KanbanServiceService } from '../kanban-service.service';
import {HttpClient,HttpEventType} from '@angular/common/http';




@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  constructor(private _service:KanbanServiceService,
    public dialogRef:MatDialogRef<ModalComponent>,
    private _http:HttpClient) { }

  candidateObj:any;
  // Upload Image Parameter-------------

  uploadImage!:File;
  dbImage:any;
  postResponse:any;
  successResponse!:String;
  image:any;



  // --------------------------------------
  

            

  ngOnInit(): void {
    console.log("nginIt activated")
    this._service.giveDatatoModal(this.candidateObj).subscribe(
      response=>{console.log(response);this.candidateObj=response},
      error=>{("error occurred")}
    );
    console.log("This is from modal component")
  }

  closeModal(){
    this.dialogRef.close();
  }

  onImageUpload(event:any){
    this.uploadImage=event.target.files[0];
  }
  
  imageUploadAction(){
    const imageFormData=new FormData();
    imageFormData.append('image',this.uploadImage,this.uploadImage.name);
    this._service.uploadingImage(imageFormData).subscribe(
      response=>{console.log("response received");this.postResponse=response;
                                                  this.successResponse=this.postResponse.body.message},
      error=>{("error occurred");this.successResponse="Image failed to upload"}
    );
  }

  viewImage(){
    this._service.viewingImage(this.image).subscribe(
      response=>{this.postResponse=response;this.dbImage='data:image/jpeg;base64,'+this.postResponse.image},
      error=>{}
    );
  }
}
