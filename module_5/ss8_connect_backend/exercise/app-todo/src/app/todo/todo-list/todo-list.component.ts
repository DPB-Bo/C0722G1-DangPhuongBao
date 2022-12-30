import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ToDoServiceService} from '../to-do-service.service';
import {IToDoUnit} from '../ito-do-unit';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit, OnChanges {
  toDoList: IToDoUnit[] = [];

  flag: string = '';
  toDoToEdit: IToDoUnit = {id: 0, content: ''};
  toDoToDelete: IToDoUnit = {id: 0, content: ''};

  constructor(private tService: ToDoServiceService) {
    this.tService.getAll().subscribe(data => {
      this.toDoList = data;
    }, error => {

    }, () => {
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
  }

  ngOnInit(): void {
  }

  updateOnCreate() {
    this.tService.getAll().subscribe(data => {
      this.toDoList = data;
    }, error => {

    }, () => {
    });
  }
}
