import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Button, Input } from '../components/atoms';

export default {
  title: 'atoms/Button',
  componet: Button,
  argTypes: {
    theme: {
      options: ['gray', 'orange'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof Button>;

const Template: ComponentStory<typeof Button> = (args) => <Button {...args} />;

export const Gray = Template.bind({});

Gray.args = {
  theme: 'gray',
  label: 'button',
};

export const Orange = Template.bind({});

Orange.args = {
  theme: 'orange',
  label: 'button',
};
