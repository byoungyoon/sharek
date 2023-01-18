import { DisabledInput, SelectDiv } from '@components/atoms';
import React, { ForwardedRef, forwardRef, useEffect, useState } from 'react';
import Arrow from '@constants/svg/arrow.svg';
import { useSpring, animated, config, useSpringRef, useChain } from '@react-spring/web';

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

const selectAnimation = (open: boolean) => {
  const { rotate } = useSpring({
    from: { rotate: 0 },
    to: { rotate: open ? 180 : 0 },
    config: config.stiff,
  });

  return { rotate };
};

const optionAnimation = (open: boolean) => {
  const opacityRef = useSpringRef();
  const { opacity, cursor } = useSpring({
    ref: opacityRef,
    from: { opacity: 0, cursor: 'auto' },
    to: {
      opacity: open ? 1 : 0,
      cursor: open ? 'pointer' : 'auto',
    },
    config: config.stiff,
  });

  const displayRef = useSpringRef();
  const { display } = useSpring({
    ref: displayRef,
    from: { display: 'none' },
    to: {
      display: open ? 'block' : 'none',
    },
  });

  useChain(open ? [displayRef, opacityRef] : [opacityRef, displayRef]);

  return { opacity, display, cursor };
};

export const Select = forwardRef((props: SelectProps, ref: ForwardedRef<HTMLInputElement>) => {
  const { theme = 'gray', data = [], ...prop } = props;

  const [open, setOpen] = useState<boolean>(false);
  const [selectData, setSelectData] = useState<dataTypes>(defaultData);

  const optionBorderColor = theme === 'gray' ? 'border-myGray' : 'border-myOrange';
  const svgColor = theme === 'gray' ? 'fill-myGray' : 'fill-myOrange';

  const { opacity, display, cursor } = optionAnimation(open);
  const { rotate } = selectAnimation(open);

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
    if (!open) return;

    setSelectData({ label: label, value: value });
  };

  const isIndex = (index: number) => {
    if (index === 0) return 'start';
    else if (index === data.length - 1) return 'end';
  };

  return (
    <div className="relative min-w-sm max-w-md" tabIndex={-1} onClick={onClickSelect} onBlur={onBlurSelect}>
      <DisabledInput theme={theme} label={selectData.label} style={{ cursor: 'pointer', paddingRight: '2.3rem' }} />
      <animated.div
        className="absolute top-2 right-2"
        style={{ transform: rotate.to((rotate) => `rotateZ(${rotate}deg)`) }}
      >
        <Arrow className={svgColor} width="24" height="24" />
      </animated.div>
      <input ref={ref} type="hidden" value={selectData.value} />
      <animated.div
        className={[
          'absolute',
          'top-full',
          'left-0',
          'w-full',
          'border',
          'rounded-md',
          `${optionBorderColor}`,
          'z-10',
          'inline-block',
        ].join(' ')}
        style={{ opacity, display, cursor }}
      >
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
      </animated.div>
    </div>
  );
});
