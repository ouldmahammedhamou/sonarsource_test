/** Valeurs autorisées : 6, 8, 10, 12 (vérification côté front uniquement). */
export interface Stats {
  INT: number;
  STR: number;
  DEX: number;
  WILL: number;
}

export const STAT_VALUES = [6, 8, 10, 12] as const;

export function isStatValid(value: number | string): boolean {
  const n = typeof value === 'string' ? parseInt(value, 10) : value;
  return !Number.isNaN(n) && STAT_VALUES.includes(n as 6 | 8 | 10 | 12);
}
