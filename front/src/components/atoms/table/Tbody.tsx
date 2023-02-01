import React from 'react';

interface TbodyProps {
  /**
   * 자식요소로 tr array | tr
   */
  children: Array<JSX.Element> | JSX.Element;
}

/**
 * Tbody Component (atoms)
 */
export const Tbody = (props: TbodyProps) => {
  const { children, ...prop } = props;

  return <tbody {...prop}>{children}</tbody>;
};
