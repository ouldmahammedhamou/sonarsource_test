import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'list', pathMatch: 'full' },
  { path: 'list', loadComponent: () => import('./pages/list/list.component').then(m => m.ListComponent) },
  { path: 'create', loadComponent: () => import('./pages/create/create.component').then(m => m.CreateComponent) },
  { path: 'perso/:id', loadComponent: () => import('./pages/detail/detail.component').then(m => m.DetailComponent) },
  { path: '**', redirectTo: 'list' },
];
