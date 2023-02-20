import React from 'react';
import { Avatar, AvatarProps, DefaultTable, DefaultTableProps } from '@components/molecules';

export interface UserProfileProps {
  theme?: 'gray' | 'orange';
  tableOpt: DefaultTableProps;
  avatarOpt: AvatarProps;
}

export const UserProfile = (props: UserProfileProps) => {
  const { theme = 'gray', tableOpt, avatarOpt } = props;
  const { isAvatar = 'none', avatarSize } = avatarOpt;
  const { header, height, columns, data } = tableOpt;

  return (
    <div>
      <Avatar isAvatar={isAvatar} avatarSize={avatarSize} />
      <DefaultTable header={header} height={height} columns={columns} data={data} />
    </div>
  );
};
