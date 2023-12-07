export class Post {
  id: number;
  userName: string;
  title: string;
  content: string;
  codeContent: string;
  tags: string[];

  constructor(data: any) {
    this.id = data.id || 0;
    this.userName = data.userName || '';
    this.title =  data.title  || '';
    this.content = data.content|| '';
    this.codeContent = data.codeContent|| '';
    this.tags = data.tags || [];
  }
}
