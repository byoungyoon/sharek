import React from 'react';
import { Alert } from '@components/molecules';
import { ComponentMeta, ComponentStory } from '@storybook/react';

export default {
  title: 'molecules/Alert',
  componet: Alert,
} as ComponentMeta<typeof Alert>;

const Template: ComponentStory<typeof Alert> = (args) => (
  <>
    <Alert type="success">You can access all the files in the folder</Alert>
    <div className="h-[30px]" />
    <Alert type="warning">Sorry, you are not authorized to have access to delete the file</Alert>
    <div className="h-[30px]" />
    <Alert type="error">Viewers of this file can see comments and suggestions</Alert>
    <div className="h-[30px]" />
    <Alert type="info">Anyone on the internet can view these files</Alert>
  </>
);

export const Overview = Template.bind({});

const SampleTemplate: ComponentStory<typeof Alert> = (args) => <Alert {...args} />;
export const Sample = SampleTemplate.bind({});

Sample.args = {
  children: 'test',
  type: 'success',
};

Sample.argTypes = {
  type: {
    options: ['success', 'warning', 'error', 'info'],
    control: { type: 'radio' },
  },
};
