import React, { useState } from 'react';

export const Login = () => {
  const [color, setColor] = useState('light');

  const handleClickButton = () => {
    setColor((color) => (color === 'light' ? 'dark' : 'light'));
  };

  return (
    <div className={color}>
      <div className="dark:text-myGray text-myOrange">123</div>
      <div className="tablet:text-myGray desktop:text-myOrange">123</div>

      <button type="button" onClick={handleClickButton}>
        test
      </button>
    </div>
  );
};
