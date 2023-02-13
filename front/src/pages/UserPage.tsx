import React, { useEffect, useMemo } from 'react';
import { UserInfo, UserPost, UserPw, UserWarning } from '@components/templates';
import { useNavigate, useParams } from 'react-router-dom';
import { useToken } from 'layouts';
import { AlertType, useAlertOpen } from '@utils/index';
import { Error404 } from './404';

export const UserPage = () => {
  const token = useToken();
  const navigate = useNavigate();
  const { setOpen, setAlert } = useAlertOpen();

  const { key } = useParams();

  useEffect(() => {
    if (token === null) {
      setOpen(setAlert(AlertType.ERROR, '접근 권한이 없습니다.'));
      navigate(-1);
    }
  }, [token]);

  const result = useMemo(() => {
    switch (key) {
      case 'info':
        return <UserInfo />;
      case 'post':
        return <UserPost />;
      case 'pw':
        return <UserPw />;
      case 'warning':
        return <UserWarning />;
      default:
        return <Error404 />;
    }
  }, [key]);

  return <div>{result}</div>;
};
