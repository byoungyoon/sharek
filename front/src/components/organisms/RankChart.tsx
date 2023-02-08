import React, { useState } from 'react';
import { Pagination, DefaultTable, TableColumnTypes, TableDataTypes, SearchInput } from '@components/molecules';

export interface RankChartProps {
  theme?: 'gray' | 'orange';
  pagenationOpt: {
    perPage?: number;
    total?: number;
    pageRangeDisplayed?: number;
  };
  tableOpt: {
    header?: boolean;
    height?: string;
    columns?: Array<TableColumnTypes>;
    data?: Array<TableDataTypes>;
  };
}

export const RankChart = (props: RankChartProps) => {
  const { theme = 'gray', pagenationOpt, tableOpt } = props;
  const { header, height, columns, data } = tableOpt;
  const { perPage, total, pageRangeDisplayed } = pagenationOpt;
  return (
    <div>
      <SearchInput theme={theme} />
      <DefaultTable header={header} height={height} columns={columns} data={data} />
      <Pagination theme={theme} perPage={perPage} total={total} pageRangeDisplayed={pageRangeDisplayed} />
    </div>
  );
};
