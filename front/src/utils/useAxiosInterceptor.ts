import { CustomAxios } from '@services/index';
import { AxiosError, AxiosRequestConfig, AxiosResponse, RawAxiosRequestHeaders } from 'axios';
import { useEffect } from 'react';
import { useStorage } from './useStorage';
import { IAlert, useAlert } from './useStore';

export const useAxiosInterceptor = () => {
  const { setOpen } = useAlert();

  const alert: IAlert = {
    open: true,
    type: 'error',
    message: '',
  };

  const requestHandler = (config: AxiosRequestConfig) => {
    if (!config.url?.startsWith('/api')) {
      const { getItem } = useStorage;
      const user = getItem('user');

      if (user == null) {
        alert.type = 'info';
        alert.message = '로그인이 필요한 서비스입니다.';
      } else {
        // eslint-disable-next-line
        config.headers = config.headers ?? {};
        // eslint-disable-next-line
        (config.headers as RawAxiosRequestHeaders).Authorization = `Bearer ${user.token}`;
      }
    }

    return config;
  };

  const responseHandler = (response: AxiosResponse) => {
    return response;
  };

  const errorHandler = (error: AxiosError) => {
    if (error.response) {
      alert.type = 'error';
      switch (error.response.status) {
        case 400:
          alert.message = 'HTTP 통신을 하는 매개변수가 잘못되었습니다.';
          setOpen(alert);
          break;
        case 401:
          alert.message = '해당하는 기능에 대한 권한이 없습니다.';
          setOpen(alert);
          break;
        case 500:
          alert.message = '서버 오류입니다.';
          setOpen(alert);
          break;
        default:
          alert.message = `${error.code} : ${error.message}`;
          break;
      }
    }
  };

  const requestInterceptor = CustomAxios.interceptors.request.use(requestHandler);
  const responseInterceptor = CustomAxios.interceptors.response.use(responseHandler, errorHandler);

  useEffect(() => {
    return () => {
      CustomAxios.interceptors.request.eject(requestInterceptor);
      CustomAxios.interceptors.response.eject(responseInterceptor);
    };
  }, [responseInterceptor]);
};
