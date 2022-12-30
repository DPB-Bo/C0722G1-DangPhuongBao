import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {IToDoUnit} from './ito-do-unit';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ToDoServiceService {
  URL_TODO = 'http://localhost:3000/IToDoUnit';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<IToDoUnit[]> {
    return this.httpClient.get<IToDoUnit[]>(this.URL_TODO);
  }

  save(IToDoUnit: IToDoUnit) {
    return this.httpClient.post<IToDoUnit>(this.URL_TODO, IToDoUnit);
  }

  updateToDo(value: IToDoUnit) {
    return this.httpClient.put<IToDoUnit>(this.URL_TODO + '/' + value.id, value);
  }

  deleteToDo(value: IToDoUnit) {
    return this.httpClient.delete<IToDoUnit>(this.URL_TODO + '/' + value.id);
  }
}
