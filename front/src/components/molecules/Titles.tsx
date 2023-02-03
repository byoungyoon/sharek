import React, { CSSProperties } from 'react';
import { Title } from '@components/atoms/title/Title';

interface TitlesProps {
  label?: string;
  fontWeight: 'bold' | 'medium' | 'light';
}

export const Titles = (props: TitlesProps) => {
  const { label, fontWeight } = props;
  const h1 = 'h1';
  const h2 = 'h2';
  const h3 = 'h3';
  const h4 = 'h4';

  return (
    <div>
      <Title fontWeight={fontWeight} label={label} fontStyle={h1} />
      <Title fontWeight={fontWeight} label={label} fontStyle={h2} />
      <Title fontWeight={fontWeight} label={label} fontStyle={h3} />
      <Title fontWeight={fontWeight} label={label} fontStyle={h4} />
    </div>
  );
};
