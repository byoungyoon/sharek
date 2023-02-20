import React, { CSSProperties } from 'react';

export interface AvatarProps {
  isAvatar: 'none' | 'avatar';
  avatarSize?: 'lg' | 'sm';
  style?: CSSProperties;
}

export const Avatar = (props: AvatarProps) => {
  const { isAvatar, avatarSize } = props;
  const mySize = avatarSize === 'lg' ? 'w-1/4 h-1/4' : 'w-10 h-10';
  const classArr = ['border', 'border-myGray', 'rounded-full', `${mySize}`, 'm-0', 'inline-block'];
  const ImgSrc =
    isAvatar === 'none' ? 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png' : '';
  return <img alt="avatar" src={`${ImgSrc}`} className={classArr.join(' ')} {...props} />;
};
