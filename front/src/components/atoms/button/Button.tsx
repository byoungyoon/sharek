import React, { CSSProperties, MouseEvent } from 'react';

interface ButtonProps {
  label: string;
  theme?: 'gray' | 'orange';
  style?: CSSProperties;
  onClick?: (event: MouseEvent<HTMLButtonElement>) => void;
}

export const Button = ({ label, theme = 'gray', ...prop }: ButtonProps) => {
  const borderColor = theme === 'gray' ? 'border-myGray text-myGray' : 'border-myOrange text-myOrange';
  const hoverColor = theme === 'gray' ? 'hover:bg-myGray' : 'hover:bg-myOrange';
  const classArr = [
    'border', // 1px
    `${borderColor}`,
    `${hoverColor}`,
    'hover:text-white',
    'focus:outline-none',
    'min-w-smBtn',
    'p-1.5',
    'px-3', // padding-horizon
    'rounded-md',
  ];

  return (
    <button type="button" className={classArr.join(' ')} {...prop}>
      {label}
    </button>
  );
};
