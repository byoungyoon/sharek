import React from 'react';
import { Titles } from '@components/molecules';
import { ComponentMeta, ComponentStory } from '@storybook/react';

export default {
  title: 'molecules/Titles',
  componet: Titles,
} as ComponentMeta<typeof Titles>;

const Template: ComponentStory<typeof Titles> = (args) => <Titles {...args} />;

export const Bold = Template.bind({});

Bold.args = {
  label: '안녕하세요',
  fontWeight: 'bold',
};

export const Medium = Template.bind({});

Medium.args = {
  label: '안녕하세요',
  fontWeight: 'medium',
};

export const Light = Template.bind({});

Light.args = {
  label: '안녕하세요',
  fontWeight: 'light',
};
