import React from 'react';

import { createRoot } from 'react-dom/client';
import App from './App';

const conatiner = document.getElementById('root') as HTMLElement;
const root = createRoot(conatiner);

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);
