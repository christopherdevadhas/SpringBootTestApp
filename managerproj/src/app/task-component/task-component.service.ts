import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskDetail } from './task';


@Injectable()
export class SampleService{
	apiAddress:string;
	data:Array<TaskDetail> = [];
	constructor(private http: HttpClient) { 
	
	this.apiAddress='http://localhost:8080/taskdetails/tasks';
	}
smpls=['test task smpl1','test task smpl2', 'test task smpl3','test task smpl4'];

getTask() {
 
   return this.http.get<Array<TaskDetail>>(this.apiAddress);
   
}

addTask(taskdetail : TaskDetail){
	return this.http.post<TaskDetail>(this.apiAddress, taskdetail);
}
}