import {Building} from "./building";
import {Student} from "./student";

export interface Apartment {
  id?: number;
  apartmentNumber?: string;
  apartmentAddress?: Building;

}
