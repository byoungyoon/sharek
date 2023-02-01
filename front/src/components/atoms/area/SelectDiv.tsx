import React, { MouseEvent, MouseEventHandler } from 'react';

interface SelectDivProps {
  label: string;
  value: string;
  selected: boolean;
  index?: 'start' | 'end';
  onClick?: (label: string, value: string) => MouseEventHandler<HTMLDivElement>;
}

export const SelectDiv = (props: SelectDivProps) => {
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

  const classArr = ['p-1.5', `${bgColor}`, 'hover:bg-myOrange-pale', `${isRounded()}`, 'break-all'];

  return (
    <div className={classArr.join(' ')} onClick={onClick(label, value)}>
      {label}
    </div>
  );
};
