import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Input } from '@components/atoms';

export default {
  title: 'atoms/Input',
  componet: Input,
  argTypes: {
    border: {
      options: ['gray', 'orange'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof Input>;

const Template: ComponentStory<typeof Input> = (args) => <Input {...args} />;

export const Gray = Template.bind({});

Gray.args = {
  border: 'gray',
  label: 'input',
};

export const Orange = Template.bind({});

Orange.args = {
  border: 'orange',
  label: 'input',
};
