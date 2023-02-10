import React from 'react';

import { MainPage, PostPage, RankPage, UserPage, Error404 } from './pages';

export const element = [
  {
    path: '/',
    element: <MainPage />,
  },
  {
    path: '/post',
    element: <PostPage />,
  },
  {
    path: '/rank',
    element: <RankPage />,
  },
  {
    path: '/user',
    element: <UserPage />,
  },
  {
    path: '*',
    element: <Error404 />,
  },
];
