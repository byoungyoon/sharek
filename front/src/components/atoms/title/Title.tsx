import React from 'react';

interface TitleProps {
  /**
   * 자식요소로 label
   */
  label?: string;

  /**
   * font weight 선택
   */
  fontWeight?: 'bold' | 'medium' | 'light';

  /**
   * font size
   */
  fontStyle?: 'h1' | 'h2' | 'h3' | 'h4';
}

/**
 * Title Component (atoms)
 */
export const Title = (props: TitleProps) => {
  const { label, fontWeight = 'light', fontStyle = 'h4', ...prop } = props;

  const getFontWeight = () => {
    switch (fontWeight) {
      case 'bold':
        return 'font-myBold';
      case 'medium':
        return 'font-myMed';
      case 'light':
        return 'font-myLight';
      default:
        return 'font-myLight';
    }
  };

  const getFontStyle = () => {
    switch (fontStyle) {
      case 'h1':
        return 'text-myH1';
      case 'h2':
        return 'text-myH2';
      case 'h3':
        return 'text-myH3';
      case 'h4':
        return 'text-myH4';
      default:
        return 'text-myH4';
    }
  };

  const classArr = ['p-2', getFontStyle(), getFontWeight()];

  return (
    <p className={classArr.join(' ')} {...prop}>
      {label}
    </p>
  );
};
