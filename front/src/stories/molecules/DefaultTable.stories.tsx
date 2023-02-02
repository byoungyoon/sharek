import React from 'react';
import { DefaultTable, TableColumnTypes, TableDataTypes } from '@components/molecules';
import { ComponentMeta, ComponentStory } from '@storybook/react';

export default {
  title: 'molecules/DefaultTable',
  component: DefaultTable,
  argTypes: {
    header: {
      options: [true, false],
      control: { type: 'radio' },
    },
  },
} as ComponentMeta<typeof DefaultTable>;

const Template: ComponentStory<typeof DefaultTable> = (args) => <DefaultTable {...args} />;

const sampleColumn: Array<TableColumnTypes> = [
  {
    label: '#',
    key: 'num',
  },
  {
    label: '성',
    key: 'firstName',
  },
  {
    label: '이름',
    key: 'lastName',
  },
  {
    label: '전화번호',
    key: 'phone',
  },
  {
    label: '성별',
    key: 'gender',
  },
  {
    label: '부가사항',
    key: 'option',
  },
];

const sampleData: Array<TableDataTypes> = [
  {
    num: '1',
    firstName: '김',
    lastName: '성민',
    phone: '01034078809',
    gender: '남',
    option: '매우 사이코 기질이 높음',
  },
  {
    num: '2',
    firstName: '홍',
    lastName: '길동',
    phone: '01012345678',
    gender: '남',
  },
  {
    num: '3',
    firstName: '김',
    lastName: '성민',
    phone: '01034078809',
    gender: '남',
    option: '매우 사이코 기질이 높음',
  },
  {
    num: '4',
    firstName: '강',
    lastName: '사랑',
    phone: '01011112222',
    gender: '여',
    option: '술을 매우 좋아함',
  },
  {
    num: '5',
    firstName: '김',
    lastName: '성민',
    phone: '01034078809',
    gender: '남',
  },
  {
    num: '6',
    firstName: '김',
    lastName: '성민',
    phone: '01034078809',
    gender: '남',
    option: '매우 사이코 기질이 높음',
  },
];

export const Overview = Template.bind({});
Overview.args = {
  header: true,
  columns: sampleColumn,
  data: sampleData,
};

export const Height = Template.bind({});
Height.args = {
  header: true,
  columns: sampleColumn,
  data: sampleData,
  height: '200px',
};
