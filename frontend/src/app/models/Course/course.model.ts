
export class Course{

  constructor(
    public id ?: number,
    public image ?: boolean,
    public imageFile ?: any ,
    public category: string = '',
    public ageStart: number = 0,
    public ageEnd: number = 0,
    public instructor: string = '',
    public price: number = 0,

  ) {
  }


  // students: List<User>;
  //  materials: List<Material>;
}
