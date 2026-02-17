import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Personnage, PersonnageCreate } from '../models/personnage';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class PersonnageService {
  private readonly apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getAll(): Observable<Personnage[]> {
    return this.http.get<Personnage[]>(`${this.apiUrl}/list`);
  }

  getById(id: number): Observable<Personnage> {
    return this.http.get<Personnage>(`${this.apiUrl}/perso/${id}`);
  }

  create(dto: PersonnageCreate): Observable<Personnage> {
    return this.http.post<Personnage>(`${this.apiUrl}/create`, dto);
  }
}
