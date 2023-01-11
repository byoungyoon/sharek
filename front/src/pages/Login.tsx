import React, { ChangeEvent, useState } from 'react';
import { Input } from '../components/atoms';

export const Login = () => {
  const [color, setColor] = useState('light');

  const [value, setValue] = useState({
    test1: '',
    test2: '',
  });

  const handleClickButton = () => {
    setColor(color === 'light' ? 'dark' : 'light');
  };

  const handleChangeValue = (test: string) => (event: ChangeEvent<HTMLInputElement>) => {
    setValue({ ...value, [test]: event.target.value });
  };

  return (
    <div className={color}>
      <div className="dark:text-myOrange-focus text-myOrange">123</div>
      <div className="tablet:text-myGray desktop:text-myOrange">123</div>

      <button type="button" onClick={handleClickButton}>
        test
      </button>

      <Input label={value.test1} border="gray" onChange={handleChangeValue('test1')} />
      <Input label={value.test2} border="gray" onChange={handleChangeValue('test2')} />
    </div>
  );
};
