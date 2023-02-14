import React from 'react';

import Shark from '@constants/svg/shark.svg';

interface LogoProps {
  theme?: 'light' | 'dark';
}

export const Logo = (props: LogoProps) => {
  const { theme = 'light' } = props;

  const fillColor = theme === 'light' ? 'fill-theme-light' : 'fill-theme-dark';

  return <Shark className={fillColor} width={60} height={45} />;
};
