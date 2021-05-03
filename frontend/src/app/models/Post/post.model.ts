
export class Post{

  constructor(
    public id?: number,
  public imageFile ?:any,
  public image ?: boolean,
  public title: string = '',
  public description: string='',
  )
  {}
}
