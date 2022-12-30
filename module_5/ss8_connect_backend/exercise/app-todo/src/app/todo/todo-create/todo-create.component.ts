import {Component, OnInit, Output} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {ToDoServiceService} from '../to-do-service.service';
import {EventEmitter} from '@angular/core';

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.css']
})
export class TodoCreateComponent implements OnInit {
  toDoUnit = this.fb.group({
    id: [],
    content: ['']
  });

  @Output() emitter = new EventEmitter();

  constructor(private fb: FormBuilder, private tService: ToDoServiceService) {
  }

  ngOnInit(): void {
  }

  saveToDo() {
    if (this.toDoUnit.valid) {
      this.tService.save(this.toDoUnit.value).subscribe(data => {
        this.emitter.emit('true');
      });
    }
  }
}
