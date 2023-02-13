import React from 'react';
import { Button } from '@components/atoms';
import { ThemeType, useTheme } from '@utils/zustand/useTheme';

export const ThemeButton = () => {
  const { theme, setTheme } = useTheme();

  const onClick = () => {
    setTheme({ theme: theme === ThemeType.LIGHT ? ThemeType.DARK : ThemeType.LIGHT });
  };

  return (
    <div className="fixed bottom-5 right-5 rounded-lg">
      {theme === ThemeType.LIGHT && <Button theme="gray" onClick={onClick} label="다크 모드로 보기" />}
      {theme === ThemeType.DARK && <Button theme="orange" onClick={onClick} label="라이브 모드로 보기" />}
    </div>
  );
};
