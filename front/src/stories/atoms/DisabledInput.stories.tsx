import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { DisabledInput } from '@components/atoms';

export default {
  title: 'atoms/DisabledInput',
  componet: DisabledInput,
  argTypes: {
    theme: {
      options: ['gray', 'orange'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof DisabledInput>;

const Template: ComponentStory<typeof DisabledInput> = (args) => <DisabledInput {...args} />;

export const Gray = Template.bind({});

Gray.args = {
  theme: 'gray',
  label: 'input',
};

export const Orange = Template.bind({});

Orange.args = {
  theme: 'orange',
  label: 'input',
};
