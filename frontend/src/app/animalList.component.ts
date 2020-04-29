import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { Animal } from './animal.model';
import {ZooserviceService} from './zooservice.service';
@Component({
  selector: 'animal-list',
  templateUrl: './animalList.component.html',
  styleUrls: ['app.component.css']
})

export class AnimalListComponent implements OnInit {
  @Input() animalList: Animal[];
  @Output() clickSender = new EventEmitter();
  responseData:any[] = [];
  animalCount:number;
  totalanimalStock:number=0;
  zooList:any[] = []
constructor(private zooService: ZooserviceService) { }

ngOnInit(){
  this.zooList = [];
  this.zooService.getAllAnimals().subscribe((data)=>{
    let obj:any[] =JSON.parse(data);
    for(let index=0;index<=obj.length-1;index++){
      this.zooList.push(obj[index]);
    }
    console.log(obj);
  })
}
  editAnimalDetails(animalToEdit: Animal) {
    this.clickSender.emit(animalToEdit);
  }

  onChangeAge(optionFromMenu) {
    this.responseData = [];
    let zoo1:HTMLSelectElement = document.getElementById("animalData")as HTMLSelectElement
    this.responseData = [];
    if(zoo1.value === "All"){
      this.totalanimalStock = 0;
      this.zooList.forEach(list=>{
        this.totalanimalStock = this.totalanimalStock + list.total ;
      })
      this.animalCount = this.totalanimalStock;
    }else{
      
      let  b = JSON.parse(optionFromMenu);
      this.animalCount = b.total;
      this.zooService.geAnimalByID(b.id).subscribe((data)=>{
        let obj:any[] =JSON.parse(data);
        for(let index=0;index<=obj.length-1;index++){
          this.responseData.push(obj[index]);
        }
      })
    }
  }

  onAnimalOperation(animal){
    let location:string = "";
    this.zooList.forEach(animal=>{
      if(animal.zooId === animal.animal){
        location = animal.zooLocation;
      }
    });

  }
}
