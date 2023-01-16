import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { SearchInput } from '@components/molecules';

export default {
  title: 'molecules/SearchInput',
  componet: SearchInput,
  argTypes: {
    theme: {
      options: ['gray', 'orange'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof SearchInput>;

const Template: ComponentStory<typeof SearchInput> = (args) => <SearchInput {...args} />;

export const Gray = Template.bind({});

Gray.args = {
  theme: 'gray',
};

export const Orange = Template.bind({});

Orange.args = {
  theme: 'orange',
};
