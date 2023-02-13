export interface IUser {
  id: string;
  pw?: string;
  name?: string;
  nickname?: string;
  email?: string;
  img?: string;
  team?: string;
  state?: '활성화' | '휴먼' | '정지';
  point?: number;
  auth?: '관리자' | '회원';
  regDt?: string;
  modDt?: string;
}

export interface IToken extends IUser {
  accessToken: string;
}
