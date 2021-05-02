export class User{

  constructor(
    public id?: number,
    public imageFile ?:any,
    public  image ?: boolean,
    public email: string = '',
    public name: string = '',
    public password: string = '',
    public rol: string = '',
  // finishedMaterials:List<Material>
    public numberMaterial: number =0,
) {
}
}
