import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { PersonnageService } from '../../services/personnage.service';
import { Personnage } from '../../models/personnage';

@Component({
  selector: 'app-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css',
})
export class DetailComponent implements OnInit {
  personnage: Personnage | null = null;
  loading = true;
  error: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private personnageService: PersonnageService,
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (!id) {
      this.loading = false;
      return;
    }
    const idNum = +id;
    this.personnageService.getById(idNum).subscribe({
      next: (data) => {
        this.personnage = data;
        this.loading = false;
      },
      error: () => {
        this.error = 'Personnage introuvable.';
        this.loading = false;
      },
    });
  }
}
