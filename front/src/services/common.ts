import axios, { AxiosRequestConfig, AxiosResponse, RawAxiosRequestHeaders } from 'axios';
import { persistentStorage } from '@utils/index';

const webpackMode = process.env.NODE_ENV || 'development';

const devURL = 'localhost:9096';
const proURL = 'localhost:9096'; // TODO 배포 서버 미정

const baseURL = webpackMode === 'development' ? devURL : proURL;
const option = axios.create({
  baseURL,
  headers: {
    'Content-type': 'application/json; charset=utf-8',
  },
});

export const CustomAxios = option;
export const CustomAxiosToAuth = option;

// request 하기 전 동작 (인가 필요한 서비스)
const onReqToAuth = (config: AxiosRequestConfig) => {
  const user = persistentStorage.getItem('user');
  if (user === null) {
    // TODO 인가되지 않은 요청 처리

    throw new Error();
  }

  // eslint-disable-next-line
  config.headers = config.headers ?? {};
  // eslint-disable-next-line
  (config.headers as RawAxiosRequestHeaders).Authorization = `Bearer ${user.token}`;

  return config;
};

// response 받은 후 동작 (인가 필요한 서비스)
const onResToAuth = (response: AxiosResponse) => {
  return response;
};

// response 받은 후 동작 에러 헨들러 (인가 필요한 서비스)
// eslint-disable-next-line
const onResErrorToAuth = (error: any) => {
  // eslint-disable-next-line
  error.response = error.response ?? {};

  switch (error.response.status) {
    case 401:
      persistentStorage.setItem('user');
      // TODO 토큰만료 에러처리
      break;
    case 500:
      // TODO 서버오류 에러처리
      break;
    default:
      break;
  }

  return Promise.reject(error);
};

CustomAxiosToAuth.interceptors.request.use(onReqToAuth);
CustomAxiosToAuth.interceptors.response.use(onResToAuth, onResErrorToAuth);
