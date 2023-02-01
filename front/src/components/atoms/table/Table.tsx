import React, { CSSProperties } from 'react';

interface TableProps {
  /**
   * 자식요소로 thead, tbody
   */
  children: Array<JSX.Element>;

  /**
   * css prop (tbody)
   */
  style?: CSSProperties;
}

/**
 * Table Component (atoms)
 */
export const Table = (props: TableProps) => {
  const { children, ...prop } = props;

  const tableClassArr = ['text-center', 'text-myGray', 'table-fixed', 'w-full', 'break-all'];
  const overflowYClassArr = [
    'overflow-y-scroll',
    'scrollbar-thin',
    'scrollbar-thumb-myGray',
    'scrollbar-track-gray-50',
  ];
  const overflowXClassArr = [
    'overflow-x-scroll',
    'scrollbar-thin',
    'scrollbar-thumb-myGray',
    'scrollbar-track-gray-50',
  ];

  return (
    <div className={overflowXClassArr.join(' ')}>
      <div className="min-w-lg tablet:min-w-md">
        <table className={tableClassArr.join(' ')}>{children[0]}</table>
        <div className={overflowYClassArr.join(' ')} {...prop}>
          <table className={tableClassArr.join(' ')}>{children[1]}</table>
        </div>
      </div>
    </div>
  );
};
