import React from 'react';

interface TrProps {
  /**
   * 자식요소로 td array | th array | td | th
   */
  children?: Array<JSX.Element> | JSX.Element;
}

/**
 * Tr Component (atoms)
 */
export const Tr = (props: TrProps) => {
  const { children, ...prop } = props;

  return (
    <tr className="border-b" {...prop}>
      {children}
    </tr>
  );
};
