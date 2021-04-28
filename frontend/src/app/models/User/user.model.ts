import { Material } from '../Material/material.model';

export interface User{
  id?: number;
  email: string;
  name: string;
  password: string;
  role: string;
  // imageFile:string;
  image: boolean;
  // finishedMaterials:List<Material>
  numberMaterials: number;
}
