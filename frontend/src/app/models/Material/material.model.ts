import { Course } from '../Course/course.model';
import {User} from '../User/user.model';

export class Material{


  constructor(
    public id?: number,
    public users ?: User[],
    public content ?: any,
    public course ?: Course,
    public name: string ='',

) {
}

}
