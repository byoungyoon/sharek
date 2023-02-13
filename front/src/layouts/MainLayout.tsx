import React, { useEffect, useMemo, useState } from 'react';
import { IToken } from '@services/index';
import { Outlet, useOutletContext } from 'react-router-dom';
import { useStorage } from '@utils/common/useStorage';
import { ThemeButton } from '@components/molecules';
import { ThemeType, useTheme } from '@utils/zustand/useTheme';

export const MainLayout = () => {
  const [token, setToken] = useState<IToken | null>(null);
  const storage = useStorage;

  const { theme } = useTheme();

  useEffect(() => {
    setToken(storage.getItem('token'));
  }, [storage.getItem('token')]);

  const containerArr = useMemo(
    () => [
      'w-screen h-screen',
      'flex items-center justify-center',
      'bg-page dark:dg-page-dark',
      theme === ThemeType.DARK && 'dark',
    ],
    [theme],
  );
  const mainArr = [
    'relative',
    'w-full h-full',
    'desktop:w-[1280px] desktop:h-[780px]',
    'shadow-lg',
    'flex justify-between',
    '[&>div]:p-2',
  ];

  return (
    <div className={containerArr.join(' ')}>
      <div className={mainArr.join(' ')}>
        <div className="bg-nav dark:bg-nav-dark w-[300px]">메뉴</div>
        <div className="bg-main dark:bg-main-dark w-full">
          <Outlet context={token} />
        </div>
        <div className="bg-main dark:bg-main-dark">추가 컨텐츠</div>
        <ThemeButton />
      </div>
    </div>
  );
};

type ContextType = { user: IToken | null };

export const useToken = () => {
  return useOutletContext<ContextType>();
};
