import React, { useMemo } from 'react';
import { PostAdd, PostAll, PostDetail, PostMod } from '@components/templates';
import { useParams } from 'react-router-dom';
import { Error404 } from './404';

export const PostPage = () => {
  const { key } = useParams();

  const result = useMemo(() => {
    switch (key) {
      case 'add':
        return <PostAdd />;
      case 'all':
        return <PostAll />;
      case 'detail':
        return <PostDetail />;
      case 'mod':
        return <PostMod />;
      default:
        return <Error404 />;
    }
  }, [key]);

  return <div>{result}</div>;
};
