import { User } from '../User/user.model';
import { Material } from '../Material/material.model';

export interface Course{
  id?: number;
  category?: string;
  ageStart?: number;
  ageEnd?: number;
  instructor?: string;
  price?: number;
  image?: boolean;
  imageFile?: any;
  // students: List<User>;
  //  materials: List<Material>;
}
