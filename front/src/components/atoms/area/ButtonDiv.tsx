import React, { MouseEventHandler } from 'react';
interface ButtonDivProps {
  theme?: 'gray' | 'orange';
  label: '이전' | '다음';
  onClick?: () => MouseEventHandler<HTMLDivElement>;
}

export const ButtonDiv = (props: ButtonDivProps) => {
  const { theme = 'gray', label, onClick = () => () => {}, ...prop } = props;
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
    <div className={classArr.join(' ')} onClick={onClick()}>
      {label}
    </div>
  );
};
