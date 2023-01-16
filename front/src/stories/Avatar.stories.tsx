import React from 'react';
import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Avatar } from '../components/atoms';

export default {
  title: 'atoms/Avatar',
  componet: Avatar,
  argTypes: {
    isAvatar: {
      options: ['none', 'avartar'],
    },
  },
} as ComponentMeta<typeof Avatar>;

const Template: ComponentStory<typeof Avatar> = (args) => <Avatar {...args} />;

export const NoneAvatar = Template.bind({});

NoneAvatar.args = {
  isAvatar: 'none',
};
