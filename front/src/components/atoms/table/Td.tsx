import React, { CSSProperties } from 'react';

interface TdProps {
  /**
   * 자식요소로 label
   */
  children?: string;

  /**
   * font weight 선택
   */
  font?: 'bold' | 'medium' | 'light';

  /**
   * css prop
   */
  style?: CSSProperties;
}

/**
 * Td Component (atoms)
 */
export const Td = (props: TdProps) => {
  const { children, font = 'light', ...prop } = props;

  const getFont = () => {
    switch (font) {
      case 'bold':
        return 'font-myBold';
      case 'medium':
        return 'font-myMed';
      default:
        return 'font-myLight';
    }
  };

  const classArr = ['px-6', 'py-4', 'text-sm', getFont()];

  return (
    <td className={classArr.join(' ')} {...prop}>
      {children}
    </td>
  );
};
