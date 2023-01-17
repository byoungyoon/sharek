import React, { CSSProperties, useMemo } from 'react';

interface DisabledInputProps {
  label: string;
  theme?: 'gray' | 'orange';
  style?: CSSProperties;
}

export const DisabledInput = (props: DisabledInputProps) => {
  const { theme = 'gray', label, ...prop } = props;

  const borderColor = useMemo(() => (theme === 'gray' ? 'border-myGray' : 'border-myOrange'), [theme]);
  const classArr = [`${borderColor}`, 'border-2', 'w-full', 'p-1.5', 'rounded-md', 'bg-white'];

  return <input type="text" value={label} className={classArr.join(' ')} disabled {...prop} />;
};
