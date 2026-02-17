import { Stats } from './stats';

export interface Personnage {
  id: number;
  nom: string;
  race: string;
  stats: Stats;
  background: string;
}

export interface PersonnageCreate {
  nom: string;
  race: string;
  stats: Stats;
  background: string;
}
