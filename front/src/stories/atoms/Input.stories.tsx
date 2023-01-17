import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Input } from '@components/atoms';

export default {
  title: 'atoms/Input',
  componet: Input,
  argTypes: {
    theme: {
      options: ['gray', 'orange'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof Input>;

const Template: ComponentStory<typeof Input> = (args) => <Input {...args} />;

export const Gray = Template.bind({});

Gray.args = {
  theme: 'gray',
};

export const Orange = Template.bind({});

Orange.args = {
  theme: 'orange',
};
