import React from 'react';

import { MainPage, PostPage, RankPage, UserPage, Error404 } from './pages';

export const element = [
  {
    path: '/',
    element: <MainPage />,
  },
  {
    path: '/post',
    children: [
      {
        index: true,
        element: <PostPage />,
      },
      {
        index: false,
        path: ':key',
        element: <PostPage />,
      },
    ],
  },
  {
    path: '/rank',
    children: [
      {
        index: true,
        element: <RankPage />,
      },
      {
        index: false,
        path: ':key',
        element: <RankPage />,
      },
    ],
  },
  {
    path: '/user',
    children: [
      {
        index: true,
        element: <UserPage />,
      },
      {
        index: false,
        path: ':key',
        element: <UserPage />,
      },
    ],
  },
  {
    path: '*',
    element: <Error404 />,
  },
];
