import React from 'react';

interface CardDivProps {
  children?: JSX.Element;
}

export const CardDiv = (props: CardDivProps) => {
  const { children } = props;

  return <div className="border-myGray border w-max p-1.5 rounded-sm">{children}</div>;
};
