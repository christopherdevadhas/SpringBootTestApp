import { Component, OnInit } from '@angular/core';
import { SampleService } from './task-component.service';
import { TaskDetail } from './task';

@Component({
  selector: 'app-task-component',
  templateUrl: './task-component.component.html',
  styleUrls: ['./task-component.component.css'],
   providers: [ SampleService ]
})
export class TaskComponentComponent implements OnInit {
smpls:string[];
inputtext=null;
sample=null
data:Array<TaskDetail>=[];
newTask : TaskDetail;

  constructor(private sm: SampleService) {
    this.newTask = new TaskDetail();
	this.smpls=this.sm.smpls;
    }
    clickAction()
{
	this.sample=this.inputtext
}
getTask()
{
	this.sm.getTask().subscribe(response => {
    console.log(response);
    this.data =response;
    
  });
}

  ngOnInit() {
  }
  addMore()
  {
    this.newTask.task = "afsfdg";
    this.newTask.project_id=1;
    this.newTask.status="active";
    this.newTask.priority="high";
    this.sm.addTask(this.newTask).subscribe(response => {
      console.log(response);
      console.log(this.data);
      this.data.push(response);
      console.log(this.data);
    });
	  
}
}
