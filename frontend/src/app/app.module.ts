import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AnimalEditDetailComponent } from './animalEditDetail.component';
import { AnimalAddComponent } from './animalAdd.component';
import { AnimalListComponent } from './animalList.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule }    from '@angular/common/http';
@NgModule({
  imports: [BrowserModule, FormsModule, BrowserAnimationsModule, HttpClientModule,],
  declarations: [ AppComponent, AnimalEditDetailComponent, AnimalAddComponent, AnimalListComponent],
  bootstrap:    [ AppComponent ]
})

export class AppModule { }
