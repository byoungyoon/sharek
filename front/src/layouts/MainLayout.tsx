import React, { useEffect, useState } from 'react';
import { IToken } from '@services/index';
import { Outlet, useOutletContext } from 'react-router-dom';
import { useStorage } from '@utils/common/useStorage';

export const MainLayout = () => {
  const [token, setToken] = useState<IToken | null>(null);
  const storage = useStorage;

  useEffect(() => {
    setToken(storage.getItem('token'));
  }, [storage.getItem('token')]);

  return (
    <div className="w-screen h-screen flex items-center justify-center">
      <div className="relative w-full h-full desktop:w-[1280px] desktop:h-[780px] mx-0 my-auto p-2 bg-background rounded-md shadow-lg">
        <Outlet context={token} />
      </div>
    </div>
  );
};

type ContextType = { user: IToken | null };

export const useToken = () => {
  return useOutletContext<ContextType>();
};
