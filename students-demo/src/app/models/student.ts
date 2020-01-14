// Interfejs Student służący do mapowania Json na obiekty
// W Angular można używać również klas. Jednak jeśli nie trzeba tworzyć instancji danej klasy lepiej korzystać z interfejsu. Jest "lżejszy"
// Zwróć uwagę, że w Angular deklarujemy zmienne odwrotnie jak w Java.  String firstName = firstName: String.
// Znak zapytania oznacza, że pole jest nieobowiązkowe.


import {Apartment} from './apartment';
import {AppUserRole} from './AppUserRole';


export interface Student {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  telephone?: string;
  password?: string;
  username?: string;
  apartment?: Apartment;
  role?: Set<AppUserRole>;
}
