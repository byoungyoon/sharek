import React from 'react';

interface CardDivProps {
  children?: JSX.Element;
  className?: string;
}

export const CardDiv = (props: CardDivProps) => {
  const { children, className } = props;

  const classArr = ['border-myGray', 'border w-max', 'p-1.5', 'rounded-sm', className];

  return <div className={classArr.join(' ')}>{children}</div>;
};
