import React from 'react';

interface TheadProps {
  /**
   * 자식요소로 tr
   */
  children?: JSX.Element;
}

/**
 * Thead Component (atoms)
 */
export const Thead = (props: TheadProps) => {
  const { children, ...prop } = props;

  return (
    <thead className="[&>tr]:bg-gray-50" {...prop}>
      {children}
    </thead>
  );
};
