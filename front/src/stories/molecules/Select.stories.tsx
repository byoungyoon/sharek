import React from 'react';

import { ComponentMeta, ComponentStory } from '@storybook/react';
import { dataTypes, Select } from '@components/molecules';

export default {
  title: 'molecules/Select',
  componet: Select,
  argTypes: {
    theme: {
      options: ['gray', 'orange'],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof Select>;

const Template: ComponentStory<typeof Select> = (args) => <Select {...args} />;
const sample: Array<dataTypes> = [
  { label: 'label1', value: 'value1' },
  { label: 'label2', value: 'value2' },
  { label: 'label3', value: 'value3' },
  { label: 'label4', value: 'value4' },
  { label: 'label5', value: 'value5' },
  { label: 'label6', value: 'value6' },
];

const sample2: Array<dataTypes> = [
  { label: 'label1', value: 'value1' },
  { label: 'label2', value: 'value2', selectValue: true },
  { label: 'label3', value: 'value3' },
  { label: 'label4', value: 'value4' },
  { label: 'label5', value: 'value5' },
  { label: 'label6', value: 'value6' },
];

export const Gray = Template.bind({});

Gray.args = {
  theme: 'gray',
  data: sample,
};

export const Orange = Template.bind({});

Orange.args = {
  theme: 'orange',
  data: sample,
};

export const SelectValue = Template.bind({});

SelectValue.args = {
  theme: 'gray',
  data: sample2,
};
