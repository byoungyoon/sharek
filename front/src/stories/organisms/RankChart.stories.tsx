import React from 'react';
import { TableColumnTypes, TableDataTypes } from '@components/molecules';
import { RankChart } from '@components/organisms';
import { ComponentMeta, ComponentStory } from '@storybook/react';
import { RowData, ColumnData } from '../../data/rankTableData';

export default {
  title: 'organisms/RankChart',
  componet: RankChart,
} as ComponentMeta<typeof RankChart>;

const Template: ComponentStory<typeof RankChart> = (args) => <RankChart {...args} />;

const sampleColumn: Array<TableColumnTypes> = ColumnData;

const sampleData: Array<TableDataTypes> = RowData;

const PageOpt = {
  perPage: 5,
  total: sampleData.length,
  pageRangeDisplayed: 5,
};

const TableOpt = {
  header: true,
  height: '1200px',
  columns: sampleColumn,
  data: sampleData,
};

export const GrayRankChart = Template.bind({});
GrayRankChart.args = {
  theme: 'gray',
  pagenationOpt: PageOpt,
  tableOpt: TableOpt,
};
