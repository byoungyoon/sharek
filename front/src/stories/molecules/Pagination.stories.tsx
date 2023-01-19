import React from 'react';
import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Pagination } from '@components/molecules';

export default {
  title: 'molecules/Pagination',
  componet: Pagination,
  argTypes: {
    theme: {
      options: ['gray', 'orange'],
    },
  },
} as ComponentMeta<typeof Pagination>;

const Template: ComponentStory<typeof Pagination> = (args) => <Pagination {...args} />;

export const Gray = Template.bind({});

// 페이지 당 게시물 : 15
// 총 게시물 : 255
Gray.args = {
  theme: 'gray',
  perPage: '15',
  total: '255',
};

// 페이지 당 게시물 : 10
// 총 게시물 : 143
export const Orange = Template.bind({});
Orange.args = {
  theme: 'orange',
  perPage: '10',
  total: '143',
};
