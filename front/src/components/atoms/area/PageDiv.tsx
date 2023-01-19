import React, { MouseEventHandler } from 'react';
import { theme } from '../../../../tailwind.config';

interface PageDivProps {
  theme?: 'gray' | 'orange';
  page: number;
  // currentPage: string;
  selected: boolean;
  onClick?: (page: number) => MouseEventHandler<HTMLDivElement>;
}

export const PageDiv = (props: PageDivProps) => {
  const { theme = 'gray', page, selected, onClick = () => () => {}, ...prop } = props;
  let bgColor;
  if (theme === 'gray') {
    bgColor = selected ? 'bg-myGray-light' : 'bg-white';
  } else {
    bgColor = selected ? 'bg-myOrange-pale' : 'bg-white';
  }

  const selectedNum = selected ? 'font-[800]' : '';
  const hoverColor = theme === 'gray' ? 'hover:bg-myGray-light' : 'hover:bg-myOrange-pale';
  const classArr = [
    'w-9',
    'h-9',
    'justify-center',
    'align-middle',
    'text-center',
    'p-1.5',
    'm-0.5',
    `${bgColor}`,
    `${hoverColor}`,
    'inline-block',
    'rounded-md',
    `${selectedNum}`,
  ];

  return (
    <div className={classArr.join(' ')} onClick={onClick(page)}>
      {page}
    </div>
  );
};
