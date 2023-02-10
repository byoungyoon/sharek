import React from 'react';

import { useRoutes } from 'react-router-dom';
import { Alert } from '@components/molecules';
import { useAxiosInterceptor } from '@utils/useAxiosInterceptor';
import { element } from './route';

import './index.css';

const App = () => {
  const routes = useRoutes(element);
  useAxiosInterceptor();

  return (
    <>
      <div>{routes}</div>
      <Alert />
    </>
  );
};

export default App;
