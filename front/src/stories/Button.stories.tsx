import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { Button, Input } from '../components/atoms';

export default {
  title: 'atoms/Button',
  componet: Button,
  argTypes: {
    background: {
      options: ['orange', 'gray'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof Button>;

const Template: ComponentStory<typeof Button> = (args) => <Button {...args} />;

export const Gray = Template.bind({});

Gray.args = {
  background: 'gray',
  label: 'button',
};

export const Orange = Template.bind({});

Orange.args = {
  background: 'orange',
  label: 'button',
};
