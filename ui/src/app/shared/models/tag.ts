export class Tag {
    tagCount: number;
    tagName: string;


    constructor(param: {
        postCount: number,
        name: string
    }) {
        this.tagName = param.name;
        this.tagCount = param.postCount;
    }

}
