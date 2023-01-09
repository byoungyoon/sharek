import React from 'react';

import { Login, Main } from './pages';

export const element = [
  {
    path: '/',
    element: <Main />,
  },
  {
    path: '/login',
    element: <Login />,
  },
];
