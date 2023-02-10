import React, { useMemo } from 'react';
import { RankAll, RankDetail } from '@components/templates';
import { useParams } from 'react-router-dom';
import { Error404 } from './404';

export const RankPage = () => {
  const { key } = useParams();

  const result = useMemo(() => {
    switch (key) {
      case 'all':
        return <RankAll />;
      case 'detail':
        return <RankDetail />;
      default:
        return <Error404 />;
    }
  }, [key]);

  return <div>{result}</div>;
};
