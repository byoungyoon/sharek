import React from 'react';
import Search from '@constants/svg/search.svg';
import { Input } from '@components/atoms';

interface SearchInputProps {
  theme?: 'gray' | 'orange';
}

export const SearchInput = ({ theme = 'gray' }: SearchInputProps) => {
  const borderColor = theme === 'gray' ? 'fill-myGray' : 'fill-myOrange';

  return (
    <div className="relative tablet:w-full laptop:w-lg desktop:w-lg ">
      <div className="absolute top-2 right-2">
        <Search className={borderColor} width="24" height="24" />
      </div>
      <Input theme={theme} style={{ paddingRight: '2.3rem' }} />
    </div>
  );
};
