import { Table, Tbody, Td, Th, Thead, Tr } from '@components/atoms';
import React, { Fragment, useMemo } from 'react';

interface DefaultTableProps {
  /**
   * column 노출 여부
   * @default true
   */
  header?: boolean;

  /**
   * tbody 높이 지정 (지정 높이 초과 시 scroll)
   */
  height?: string;

  /**
   * column 옵션
   * @default []
   */
  columns?: Array<TableColumnTypes>;

  /**
   * data 옵션
   * @default []
   */
  data?: Array<TableDataTypes>;
}

export type TableColumnTypes = {
  /**
   * 보여줄 데이터
   */
  label: string;

  /**
   * key 데이터
   */
  key: string;

  /**
   * column hidden 여부
   */
  hidden?: boolean;
};

export type TableDataTypes = {
  /**
   * ex) column key 값 : 보여줄 데이터
   */
  [key: string]: string;
};

/**
 * DefaultTable Component (molecules) - V1
 */
export const DefaultTable = (props: DefaultTableProps) => {
  const { header = true, columns = [], data = [], height } = props;

  /**
   * thead 출력
   */
  const getThead = useMemo(() => {
    return columns.map((column) => {
      return column.hidden ? <Fragment key={column.key} /> : <Th key={column.key}>{column.label}</Th>;
    });
  }, [columns]);

  /**
   * tbody 출력
   */
  const getTbody = useMemo(() => {
    const getTd = (datum: TableDataTypes) => {
      return [...Array(columns.length)].map((_, index) => {
        const column = columns[index];
        return column.hidden ? <Fragment key={column.key} /> : <Td key={column.key}>{datum[column.key]}</Td>;
      });
    };

    return data.map((datum, index) => {
      // eslint-disable-next-line react/no-array-index-key
      return <Tr key={index}>{getTd(datum)}</Tr>;
    });
  }, [columns, data]);

  return (
    <Table style={{ maxHeight: height }}>
      {header ? (
        <Thead>
          <Tr>{getThead}</Tr>
        </Thead>
      ) : (
        <Fragment key="_" />
      )}
      <Tbody>{getTbody}</Tbody>
    </Table>
  );
};
