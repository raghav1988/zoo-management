"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var animal_model_1 = require("./animal.model");
var AnimalAddComponent = (function () {
    function AnimalAddComponent() {
        this.newAnimalSender = new core_1.EventEmitter();
    }
    AnimalAddComponent.prototype.submitForm = function (name, species, age, diet, location, caretakers, likes, dislikes, sex) {
        var newAnimalToAdd = new animal_model_1.Animal(name, species, age, diet, location, caretakers, likes, dislikes, sex);
        this.newAnimalSender.emit(newAnimalToAdd);
    };
    return AnimalAddComponent;
}());
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], AnimalAddComponent.prototype, "newAnimalSender", void 0);
AnimalAddComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        selector: 'animal-add',
        templateUrl: './animalAdd-component.html',
        styleUrls: ['app.component.css']
    })
], AnimalAddComponent);
exports.AnimalAddComponent = AnimalAddComponent;
//# sourceMappingURL=animalAdd.component.js.map