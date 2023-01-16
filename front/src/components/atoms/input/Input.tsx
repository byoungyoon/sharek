import React, { CSSProperties, ForwardedRef, forwardRef, useMemo } from 'react';

interface InputProps {
  theme?: 'gray' | 'orange';
  style?: CSSProperties;
}

export const Input = forwardRef((props: InputProps, ref: ForwardedRef<HTMLInputElement>) => {
  const { theme = 'gray', ...prop } = props;

  const borderColor = useMemo(() => (theme === 'gray' ? 'border-myGray' : 'border-myOrange'), [theme]);
  const classArr = ['border-2', `${borderColor}`, 'focus:outline-none', 'w-full', 'p-1.5', 'rounded-md'];

  return <input ref={ref} type="text" className={classArr.join(' ')} {...prop} />;
});
