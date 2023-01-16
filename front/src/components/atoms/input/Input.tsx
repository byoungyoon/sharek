import React, { ChangeEvent, CSSProperties } from 'react';

interface InputProps {
  theme?: 'gray' | 'orange';
  style?: CSSProperties;
}

export const Input = ({ theme = 'gray', ...prop }: InputProps) => {
  const borderColor = theme === 'gray' ? 'border-myGray' : 'border-myOrange';
  const classArr = ['border-2', `${borderColor}`, 'focus:outline-none', 'w-full', 'p-1.5', 'rounded-md'];

  return <input type="text" className={classArr.join(' ')} {...prop} />;
};
