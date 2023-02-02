import React, { CSSProperties } from 'react';

interface AvatarProps {
  isAvatar: 'none' | 'avatar';
  style?: CSSProperties;
}

export const Avatar = ({ isAvatar = 'none', ...prop }: AvatarProps) => {
  const classArr = ['border', 'border-myGray', 'rounded-full', 'w-1/6', 'h-1/6'];
  const ImgSrc =
    isAvatar === 'none' ? 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png' : '';
  return <img alt="avatar" src={`${ImgSrc}`} className={classArr.join(' ')} {...prop} />;
};
