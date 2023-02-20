import React from 'react';
import { ComponentMeta, ComponentStory } from '@storybook/react';
import { TableColumnTypes, TableDataTypes } from '@components/molecules';
import { UserProfile } from '@components/organisms';
import { RowData, ColumnData } from '../../data/userProfileData';

export default {
  title: 'organisms/UserProfile',
  componet: UserProfile,
} as ComponentMeta<typeof UserProfile>;

const Template: ComponentStory<typeof UserProfile> = (args) => <UserProfile {...args} />;

const sampleColumn: Array<TableColumnTypes> = ColumnData;

const sampleData: Array<TableDataTypes> = RowData;

const TableOpt = {
  header: true,
  height: '300px',
  columns: sampleColumn,
  data: sampleData,
};

// const AvatarOpt = {
//   isAvatar: 'none',
//   size: 'sm',
// };

export const GrayUserProfile = Template.bind({});
GrayUserProfile.args = {
  theme: 'gray',
  tableOpt: TableOpt,
  avatarOpt: {
    isAvatar: 'none',
    avatarSize: 'lg',
  },
};
