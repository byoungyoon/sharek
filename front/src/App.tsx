import React from 'react';

import { useRoutes } from 'react-router-dom';
import { Alert } from '@components/molecules';
import { useAxiosInterceptor } from '@utils/common/useAxiosInterceptor';
import { element } from './route';

import './index.css';

const App = () => {
  const routes = useRoutes(element);
  useAxiosInterceptor();

  return (
    <>
      {routes}
      <Alert />
    </>
  );
};

export default App;
