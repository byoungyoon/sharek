import React, { useEffect, useMemo, useRef } from 'react';
import Search from '@constants/svg/search.svg';
import { Input } from '@components/atoms';

interface SearchInputProps {
  theme?: 'gray' | 'orange';
  onKeyDown?: (value: string) => void;
}

export const SearchInput = (props: SearchInputProps) => {
  const { theme = 'gray', onKeyDown = () => {} } = props;

  const borderColor = useMemo(() => (theme === 'gray' ? 'fill-myGray' : 'fill-myOrange'), [theme]);
  const target = useRef<HTMLInputElement>(null);

  const onKeyDownHandler = (event: KeyboardEvent) => {
    if (event.key === 'Enter' && target.current) onKeyDown(target.current.value);
  };

  useEffect(() => {
    target.current?.addEventListener('keydown', onKeyDownHandler);
  }, []);

  return (
    <div className="relative tablet:w-full laptop:max-w-lg desktop:max-w-lg">
      <div className="absolute top-2 right-2">
        <Search className={borderColor} width="24" height="24" />
      </div>
      <Input ref={target} theme={theme} style={{ paddingRight: '2.3rem' }} />
    </div>
  );
};
