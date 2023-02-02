import React, { MouseEventHandler } from 'react';

interface PreNextDivProps {
  label?: '이전' | '다음';
  onClick?: () => MouseEventHandler<HTMLDivElement>;
}

export const PreNextDiv = (props: PreNextDivProps) => {
  const { label, onClick = () => () => {} } = props;
  const classArr = [
    'w-13',
    'h-9',
    'justify-center',
    'align-middle',
    'text-center',
    'p-1.5',
    'my-0.5',
    'mx-6',
    'cursor-pointer',
    'hover:underline decoration-black',
    'inline-block',
    'rounded-md',
  ];

  return (
    <div className={classArr.join(' ')} role="button" tabIndex={0} onClick={onClick()}>
      {label}
    </div>
  );
};
