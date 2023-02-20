import React from 'react';
import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Avatar } from '@components/molecules';

export default {
  title: 'molecules/Avatar',
  componet: Avatar,
  // argTypes: {
  //   isAvatar: {
  //     options: ['none', 'avatar'],
  //   },
  // },
} as ComponentMeta<typeof Avatar>;

const Template: ComponentStory<typeof Avatar> = (args) => <Avatar {...args} />;

export const NoneLarge = Template.bind({});

NoneLarge.args = {
  isAvatar: 'none',
  avatarSize: 'lg',
};

export const NoneSmall = Template.bind({});

NoneSmall.args = {
  isAvatar: 'none',
  avatarSize: 'sm',
};
