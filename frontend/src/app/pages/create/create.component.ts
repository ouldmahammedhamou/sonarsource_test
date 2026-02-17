import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PersonnageService } from '../../services/personnage.service';
import { PersonnageCreate } from '../../models/personnage';
import { STAT_VALUES, isStatValid } from '../../models/stats';

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css',
})
export class CreateComponent {
  nom = '';
  race = '';
  statInt = 10;
  statStr = 10;
  statDex = 10;
  statWill = 10;
  background = '';

  statValues = STAT_VALUES;
  loading = false;
  error: string | null = null;
  formErrors: string[] = [];

  constructor(
    private personnageService: PersonnageService,
    private router: Router,
  ) {}

  validateStats(): boolean {
    this.formErrors = [];
    if (!isStatValid(this.statInt)) this.formErrors.push('INT doit être 6, 8, 10 ou 12.');
    if (!isStatValid(this.statStr)) this.formErrors.push('STR doit être 6, 8, 10 ou 12.');
    if (!isStatValid(this.statDex)) this.formErrors.push('DEX doit être 6, 8, 10 ou 12.');
    if (!isStatValid(this.statWill)) this.formErrors.push('WILL doit être 6, 8, 10 ou 12.');
    if (!this.nom?.trim()) this.formErrors.push('Le nom est requis.');
    if (!this.race?.trim()) this.formErrors.push('La race est requise.');
    return this.formErrors.length === 0;
  }

  onSubmit(): void {
    this.error = null;
    if (!this.validateStats()) return;

    this.loading = true;
    const dto: PersonnageCreate = {
      nom: this.nom.trim(),
      race: this.race.trim(),
      stats: {
        INT: Number(this.statInt),
        STR: Number(this.statStr),
        DEX: Number(this.statDex),
        WILL: Number(this.statWill),
      },
      background: this.background.trim(),
    };

    this.personnageService.create(dto).subscribe({
      next: (created) => {
        this.loading = false;
        this.router.navigate(['/perso', created.id]);
      },
      error: (err) => {
        this.loading = false;
        this.error = err?.error?.message || 'Erreur lors de la création.';
      },
    });
  }
}
