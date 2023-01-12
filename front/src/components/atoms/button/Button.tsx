import React, { ChangeEvent } from 'react';

interface ButtonProps {
  label: string;
  background?: 'gray' | 'orange';
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
}

export const Button = ({ label, background = 'gray', ...prop }: ButtonProps) => {
  const backgroundColor = background === 'gray' ? 'bg-myGray-light' : 'bg-myOrange-light';
  const classArr = ['bg-2', `${backgroundColor}`, 'focus:outline-none', 'w-1/6', 'p-1.5', 'rounded-md'];

  return <input type="button" value={label} className={classArr.join(' ')} {...prop} />;
};
