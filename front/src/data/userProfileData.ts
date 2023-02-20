import { TableDataTypes, TableColumnTypes } from '@components/molecules';

export const ColumnData: Array<TableColumnTypes> = [
  {
    label: '#',
    key: 'userNum',
    // hidden: true,
  },
  {
    label: '닉네임',
    key: 'nickName',
  },
  {
    label: '포인트',
    key: 'point',
  },
];

export const RowData: Array<TableDataTypes> = [
  {
    userNum: '1',
    nickName: '핸지',
    point: '26000',
  },
];
