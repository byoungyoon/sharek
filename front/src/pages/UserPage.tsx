import React, { useMemo } from 'react';
import { UserInfo, UserPost, UserPw, UserWarning } from '@components/templates';
import { useParams } from 'react-router-dom';
import { Error404 } from './404';

export const UserPage = () => {
  const { key } = useParams();

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
