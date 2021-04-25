import { Course } from '../Course/course.model';

export interface Material{
  id:number;
  name:string;
  //content:bytes;
  course:Course;
}
