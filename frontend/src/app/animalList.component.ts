import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { Animal } from './animal.model';

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
  zooList:any[] = [
    {"zooId":1,"zooLocation":"Delhi","animalStock":500},
    {"zooId":2,"zooLocation":"Bengaluru","animalStock":600},
    {"zooId":3,"zooLocation":"Pune","animalStock":500}
  ];


  animalListByZooID:any[] = [{"zooId":1,"animal":"Lion","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":1,"animal":"Elephant","sex":"Male","activity":"Sleeping","age":8,"master":"All"},
                              {"zooId":1,"animal":"Fox","sex":"Female","activity":"Running","age":10,"master":"All"},
                              {"zooId":1,"animal":"Bear","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":2,"animal":"Dog","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":2,"animal":"Lion","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":2,"animal":"Tiger","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":3,"animal":"Goat","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":3,"animal":"Lion","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":3,"animal":"Giraffe","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":3,"animal":"Swan","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":1,"animal":"Leopard","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":2,"animal":"Elephant","sex":"Male","activity":"Bathing","age":6,"master":"All"},
                              {"zooId":3,"animal":"Black bird","sex":"Female","activity":"Flying","age":6,"master":"All"},
                              {"zooId":3,"animal":"Bald eagle","sex":"Female","activity":"Flying","age":6,"master":"All"}
]


ngOnInit(){
  let zoo:HTMLSelectElement = document.getElementById("animalData")as HTMLSelectElement
  this.responseData = [];
  this.totalanimalStock = 0;
  this.zooList.forEach(list=>{
    this.totalanimalStock = this.totalanimalStock + list.animalStock ;
  })
  this.animalCount = this.totalanimalStock;
  this.animalListByZooID.forEach(animal=>{
    if(animal.master === zoo.value ){
        this.responseData.push(animal);
    }
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
      this.animalListByZooID.forEach(animal=>{
        if(animal.master === zoo1.value ){
            this.responseData.push(animal);
        }
      })
      this.zooList.forEach(list=>{
        this.totalanimalStock = this.totalanimalStock + list.animalStock ;
      })
      this.animalCount = this.totalanimalStock;
    }else{
      let  b = JSON.parse(optionFromMenu);
      this.animalCount = b.animalStock;
     this.animalListByZooID.forEach(animal=>{
        if(animal.zooId === b.zooId){
          this.responseData.push(animal);
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
