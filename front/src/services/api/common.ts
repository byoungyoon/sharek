import axios from 'axios';

const webpackMode = process.env.NODE_ENV || 'development';

const devURL = 'http://localhost:8080';
const proURL = 'http://localhost:8080'; // TODO 배포 서버 미정

const baseURL = webpackMode === 'development' ? devURL : proURL;

export const CustomAxios = axios.create({
  baseURL,
  headers: {
    'Content-type': 'application/json; charset=utf-8',
  },
});
