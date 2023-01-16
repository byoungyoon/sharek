import React from 'react';

import { useRoutes } from 'react-router-dom';
import { element } from './route';

import './index.css';

const App = () => {
  const routes = useRoutes(element);

  return <div>{routes}</div>;
};

export default App;
