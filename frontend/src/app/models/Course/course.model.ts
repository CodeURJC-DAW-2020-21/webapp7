import { User } from '../User/user.model';
import { Material } from '../Material/material.model';

export interface Course{
  id?: number;
  category: string;
  ageStart: number;
  ageEnd: number;
  instructor: string;
  image?:boolean;
  imageFile?:any;
  price:number;

  // students: List<User>;
  //  materials: List<Material>;
}
