import { DisabledInput, SelectDiv } from '@components/atoms';
import React, { ForwardedRef, forwardRef, useEffect, useMemo, useState } from 'react';

export interface SelectProps {
  theme?: 'gray' | 'orange';
  data?: Array<dataTypes>;
}

export type dataTypes = {
  label: string;
  value: string;
  selectValue?: boolean;
};

const defaultData: dataTypes = {
  label: '선택해주세요.',
  value: '',
  selectValue: true,
};

export const Select = forwardRef((props: SelectProps, ref: ForwardedRef<HTMLInputElement>) => {
  const { theme = 'gray', data = [], ...prop } = props;

  const [open, setOpen] = useState<boolean>(false);
  const [selectData, setSelectData] = useState<dataTypes>(defaultData);

  const optionBorderColor = useMemo(() => (theme === 'gray' ? 'border-myGray' : 'border-myOrange'), [theme]);
  const optionClassArr = [
    'absolute',
    'top-full',
    'left-0',
    'w-full',
    'border-2',
    'rounded-md',
    `${optionBorderColor}`,
    'z-10',
    'inline-block',
  ];

  useEffect(() => {
    const select = data.find((key) => key.selectValue);

    if (select) setSelectData(select);
    else data.unshift(defaultData);
  }, [data]);

  const onClickSelect = () => {
    setOpen(!open);
  };

  const onBlurSelect = () => {
    setOpen(false);
  };

  const onClickOption = (label: string, value: string) => () => {
    setSelectData({ label: label, value: value });
  };

  const isIndex = (index: number) => {
    if (index === 0) return 'start';
    else if (index === data.length - 1) return 'end';
  };

  return (
    <div className="relative min-w-sm max-w-md" tabIndex={-1} onClick={onClickSelect} onBlur={onBlurSelect}>
      <DisabledInput theme={theme} label={selectData.label} style={{ cursor: 'pointer' }} />
      <input ref={ref} type="hidden" value={selectData.value} />
      {open && (
        <div className={optionClassArr.join(' ')}>
          {data.map((key, index) => (
            <SelectDiv
              key={index}
              label={key.label}
              value={key.value}
              selected={key.value === selectData.value}
              index={isIndex(index)}
              onClick={onClickOption}
            />
          ))}
        </div>
      )}
    </div>
  );
});
