import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';
import {IToDoUnit} from '../ito-do-unit';
import {FormBuilder} from '@angular/forms';
import {ToDoServiceService} from '../to-do-service.service';

@Component({
  selector: 'app-todo-update',
  templateUrl: './todo-update.component.html',
  styleUrls: ['./todo-update.component.css']
})
export class TodoUpdateComponent implements OnInit {
  @Input() toDoEdit: IToDoUnit = {id: 0, content: ''};
  toDoEditForm = this.fb.group({});

  @Output() emitter = new EventEmitter();

  constructor(private fb: FormBuilder, private tService: ToDoServiceService) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.toDoEditForm = this.fb.group({
      id: [this.toDoEdit.id],
      content: [this.toDoEdit.content]
    });
  }

  updateToDo() {
    this.tService.updateToDo(this.toDoEditForm.value).subscribe(data => {
      this.emitter.emit('true');
    });
  }
}
