import { User } from '../User/user.model';
import { Material } from '../Material/material.model';

export interface Course{
  id?: number;
  category: string;
  ageStart: number;
  ageEnd: number;
  instructor: string;
  price:number;
  // students: List<User>;
  //  materials: List<Material>;
}
