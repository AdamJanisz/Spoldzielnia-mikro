// Interfejs Student służący do mapowania Json na obiekty
// W Angular można używać również klas. Jednak jeśli nie trzeba tworzyć instancji danej klasy lepiej korzystać z interfejsu. Jest "lżejszy"
// Zwróć uwagę, że w Angular deklarujemy zmienne odwrotnie jak w Java.  String firstName = firstName: String.
// Znak zapytania oznacza, że pole jest nieobowiązkowe.

<<<<<<< HEAD
import {Apartment} from "./apartment";
=======
import {AppUserRole} from "./AppUserRole";
>>>>>>> security

export interface Student {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  telephone?: string;
  password?: string;
<<<<<<< HEAD
  apartment?: Apartment;
=======
  role?: Set<AppUserRole>;
>>>>>>> security
}
