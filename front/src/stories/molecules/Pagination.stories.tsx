import React, { useState } from 'react';
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

// 페이지 당 게시물 : 10
// 총 게시물 : 405
// 페이지 단위 : 10
Gray.args = {
  theme: 'gray',
  perPage: 10,
  total: 299,
  pageRangeDisplayed: 1,
};

// 페이지 당 게시물 : 10
// 총 게시물 : 143
export const Orange = Template.bind({});
Orange.args = {
  theme: 'orange',
  perPage: 10,
  total: 155,
  pageRangeDisplayed: 5,
};
