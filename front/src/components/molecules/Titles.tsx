import React, { CSSProperties } from 'react';
import { Title } from '@components/atoms/title/Title';

interface TitlesProps {
  label?: string;
  fontWeight: 'bold' | 'medium' | 'light';
}

export const Titles = (props: TitlesProps) => {
  const { label, fontWeight } = props;

  return (
    <div>
      <Title fontWeight={fontWeight} label={label} fontStyle="h1" />
      <Title fontWeight={fontWeight} label={label} fontStyle="h2" />
      <Title fontWeight={fontWeight} label={label} fontStyle="h3" />
      <Title fontWeight={fontWeight} label={label} fontStyle="h4" />
    </div>
  );
};
