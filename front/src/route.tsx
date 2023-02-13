import React from 'react';
import { MainLayout } from 'layouts';

import { Error404, MainPage, PostPage, RankPage, UserPage } from './pages';

export const element = [
  {
    element: <MainLayout />,
    children: [
      {
        path: '',
        element: <MainPage />,
      },
      {
        path: 'post',
        children: [
          {
            index: true,
            element: <PostPage />,
          },
          {
            index: false,
            element: <PostPage />,
            path: ':key',
          },
        ],
      },
      {
        path: 'rank',
        children: [
          {
            index: true,
            element: <RankPage />,
          },
          {
            index: false,
            element: <RankPage />,
            path: ':key',
          },
        ],
      },
      {
        path: 'user',
        children: [
          {
            index: true,
            element: <UserPage />,
          },
          {
            index: false,
            element: <UserPage />,
            path: ':key',
          },
        ],
      },
      {
        path: '*',
        element: <Error404 />,
      },
    ],
  },
];
