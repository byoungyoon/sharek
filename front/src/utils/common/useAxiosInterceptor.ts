import { CustomAxios } from '@services/index';
import { AxiosError, AxiosResponse, InternalAxiosRequestConfig } from 'axios';
import { useEffect } from 'react';
import { useStorage } from './useStorage';
import { AlertType, useAlertOpen } from '../zustand/useAlert';

export const useAxiosInterceptor = () => {
  const { setOpen, setAlert } = useAlertOpen();

  const requestHandler = (config: InternalAxiosRequestConfig) => {
    if (!config.url?.startsWith('/api')) {
      const { getItem } = useStorage;
      const user = getItem('user');

      if (user == null) {
        setOpen(setAlert(AlertType.INFO, '로그인이 필요한 서비스입니다.'));
      } else {
        config.headers.Authorization = `Bearer ${user.token}`;
      }
    }

    return config;
  };

  const responseHandler = (response: AxiosResponse) => {
    return response;
  };

  const errorHandler = (error: AxiosError) => {
    if (error.response) {
      switch (error.response.status) {
        case 400:
          setOpen(setAlert(AlertType.ERROR, 'HTTP 통신을 하는 매개변수가 잘못되었습니다.'));
          break;
        case 401:
          setOpen(setAlert(AlertType.ERROR, '해당하는 기능에 대한 권한이 없습니다.'));
          break;
        case 500:
          setOpen(setAlert(AlertType.ERROR, '서버 오류입니다.'));
          break;
        default:
          setOpen(setAlert(AlertType.ERROR, `${error.code} : ${error.message}`));
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
