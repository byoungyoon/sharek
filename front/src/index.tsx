import React from 'react';

import { createRoot } from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';

const conatiner = document.getElementById('root') as HTMLElement;
const root = createRoot(conatiner);

root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>,
);
