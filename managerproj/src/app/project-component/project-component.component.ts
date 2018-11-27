import { Component, OnInit } from '@angular/core';
import { SampleService } from './project-component.service';

@Component({
  selector: 'app-project-component',
  templateUrl: './project-component.component.html',
  styleUrls: ['./project-component.component.css'],
   providers: [ SampleService ]
})
export class ProjectComponentComponent implements OnInit {
smpls:string[];
inputtext=null;
sample=null

clickAction()
{
	this.sample=this.inputtext
}
  constructor(private sm: SampleService) {
	this.smpls=this.sm.smpls
	  }

  ngOnInit() {
  }
  addMore()
  {
	  this.smpls.push(this.inputtext)
		this.inputtext=null;
}
}
