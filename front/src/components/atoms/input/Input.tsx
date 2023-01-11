import React, { ChangeEvent } from 'react';

interface InputProps {
  label: string;
  border?: 'gray' | 'orange';
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
}

export const Input = ({ label, border = 'gray', ...prop }: InputProps) => {
  const borderColor = border === 'gray' ? 'border-myGray' : 'border-myOrange';
  const classArr = ['border-2', `${borderColor}`, 'focus:outline-none', 'w-full', 'p-1.5', 'rounded-md'];

  return <input type="text" value={label} className={classArr.join(' ')} {...prop} />;
};
