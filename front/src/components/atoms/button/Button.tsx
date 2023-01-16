import React, { ChangeEvent } from 'react';

interface ButtonProps {
  label: string;
  theme?: 'gray' | 'orange';
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
}

export const Button = ({ label, theme = 'gray', ...prop }: ButtonProps) => {
  const borderColor = theme === 'gray' ? 'border-myGray text-myGray' : 'border-myOrange text-myOrange';
  const hoverColor = theme === 'gray' ? 'hover:bg-myGray' : 'hover:bg-myOrange';
  const classArr = [
    'border', // 1px
    `${borderColor}`,
    `${hoverColor}`,
    'hover:text-[#FFFFFF]',
    'focus:outline-none',
    'min-w-smBtn',
    'p-1.5',
    'px-3', // padding-horizon
    'rounded-md',
  ];

  return <input type="button" value={label} className={classArr.join(' ')} {...prop} />;
};
