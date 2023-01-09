import React from 'react';

import { useRoutes } from 'react-router-dom';
import { element } from './route';

import './index.css';

function App() {
  const routes = useRoutes(element);

  return <>{routes}</>;
}

export default App;
