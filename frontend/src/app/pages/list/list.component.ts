import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { PersonnageService } from '../../services/personnage.service';
import { Personnage } from '../../models/personnage';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css',
})
export class ListComponent implements OnInit {
  personnages: Personnage[] = [];
  loading = true;
  error: string | null = null;

  constructor(private personnageService: PersonnageService) {}

  ngOnInit(): void {
    this.personnageService.getAll().subscribe({
      next: (data) => {
        this.personnages = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Impossible de charger la liste. Démarre le backend (port 8080).';
        this.loading = false;
      },
    });
  }
}
