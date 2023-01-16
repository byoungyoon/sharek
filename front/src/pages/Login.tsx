import React, { ChangeEvent, useState } from 'react';
import { Input } from '@components/atoms';
import { SearchInput } from '@components/molecules';

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

  return <div className={color}></div>;
};
