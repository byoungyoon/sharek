import { IUser, CustomAxios } from '@services/index';

class LoginService {
  login(user: IUser) {
    return CustomAxios.post('/api/login', user);
  }
}

export const loginService = new LoginService();
