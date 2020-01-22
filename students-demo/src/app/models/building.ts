import {Student} from "./student";

export interface Building{
  id?: number;
  city?: string;
  street?: string;
  buildingNumber?: string;
  electricityPrice?: string;
  hotWaterPrice?: string;
  coldWaterPrice?: string;
  sewagePrice?: string;
  maintenanceFundPrice?: string;
  owner?: Student;
}
