import React from 'react';

import { Link, useRoutes } from 'react-router-dom';
import { element } from './route';

import './index.css';

const App = () => {
  const routes = useRoutes(element);

  return (
    <div>
      <div>{routes}</div>
      <div>
        <Link to="/">home</Link>
        <Link to="/login">login</Link>
      </div>
    </div>
  );
};

export default App;
