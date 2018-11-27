import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponentComponent } from './main-component/main-component.component';
import { FormsModule } from '@angular/forms';
import { TaskComponentComponent } from './task-component/task-component.component';
import { RouterModule, Routes } from '@angular/router';
import { UserComponentComponent } from './user-component/user-component.component';
import { ProjectComponentComponent } from './project-component/project-component.component';
import { HttpClientModule } from '@angular/common/http';
import { SampleService } from './task-component/task-component.service';
const routeLists : Routes = [
{path:"", component:TaskComponentComponent},
	{path:"view", component:MainComponentComponent},
		{path:"user", component:UserComponentComponent},
		{path:"project", component:ProjectComponentComponent}
	]
@NgModule({
  declarations: [
    AppComponent,
    MainComponentComponent,
    TaskComponentComponent,
    UserComponentComponent,
    ProjectComponentComponent,
	
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	FormsModule,
	HttpClientModule,
	RouterModule.forRoot(routeLists)
  ],
  providers: [SampleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
