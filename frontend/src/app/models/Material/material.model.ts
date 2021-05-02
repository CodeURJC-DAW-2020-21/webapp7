import { Course } from '../Course/course.model';
import {User} from '../User/user.model';

export interface Material{
  id?: number;
  name: string;
  users: User[];
  content: any;
  course: Course;
}
