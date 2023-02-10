export interface IPost {
  seq: number;
  userId?: string;
  title?: string;
  content?: string;
  image?: string;
  vote?: number;
  view?: number;
  regDt?: string;
  modDt?: string;
}

export interface IPostComment {
  seq: number;
  userId: string;
  regDt?: string;
  modDt?: string;
}

export interface IPostVote {
  postSeq: number;
  userId: string;
  variance?: 1 | -1;
  regDt?: string;
}

export interface IPostTag {
  postSeq: number;
  tagSeq: number;
}
