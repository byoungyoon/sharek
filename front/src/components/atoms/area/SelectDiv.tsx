import React, { MouseEvent, MouseEventHandler } from 'react';

interface TextDivProps {
  label: string;
  value: string;
  selected: boolean;
  index?: 'start' | 'end';
  onClick?: (label: string, value: string) => MouseEventHandler<HTMLDivElement>;
}

export const SelectDiv = (props: TextDivProps) => {
  const { label, value, selected, index, onClick = () => () => {} } = props;

  const bgColor = selected ? 'bg-myOrange-pale' : 'bg-white';
  const isRounded = () => {
    switch (index) {
      case 'start':
        return 'rounded-t-md';
      case 'end':
        return 'rounded-b-md';
      default:
        return '';
    }
  };

  const classArr = ['p-1.5', `${bgColor}`, 'hover:bg-myOrange-pale', `${isRounded()}`, 'cursor-pointer', 'break-all'];

  return (
    <div className={classArr.join(' ')} onClick={onClick(label, value)}>
      {label}
    </div>
  );
};
