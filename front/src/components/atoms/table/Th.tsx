import React, { CSSProperties } from 'react';

interface ThProps {
  /**
   * 자식 요소로 label
   */
  children?: string;

  /**
   * css prop
   */
  style?: CSSProperties;
}

/**
 * Th Component (atoms)
 */
export const Th = (props: ThProps) => {
  const { children = '', ...prop } = props;

  const classArr = ['text-sm', 'font-myMed', 'px-6', 'py-4'];

  return (
    <th className={classArr.join(' ')} {...prop}>
      {children}
    </th>
  );
};
