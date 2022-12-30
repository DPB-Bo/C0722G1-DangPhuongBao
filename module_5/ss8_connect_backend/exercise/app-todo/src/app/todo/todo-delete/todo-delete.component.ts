import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {IToDoUnit} from '../ito-do-unit';
import {FormBuilder} from '@angular/forms';
import {ToDoServiceService} from '../to-do-service.service';

@Component({
  selector: 'app-todo-delete',
  templateUrl: './todo-delete.component.html',
  styleUrls: ['./todo-delete.component.css']
})
export class TodoDeleteComponent implements OnInit, OnChanges {
  toDoDeleteForm = this.fb.group({});

  @Output() emitter = new EventEmitter();
  @Input() toDoDelete: IToDoUnit = {id: 0, content: ''};

  constructor(private fb: FormBuilder, private tService: ToDoServiceService) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.toDoDeleteForm = this.fb.group({
      id: [this.toDoDelete.id],
      content: [this.toDoDelete.content]
    });
  }

  deleteToDo() {
    this.tService.deleteToDo(this.toDoDeleteForm.value).subscribe(data => {
      this.emitter.emit('true');
    });
  }
}
