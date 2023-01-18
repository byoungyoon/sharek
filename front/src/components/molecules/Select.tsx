import { DisabledInput, SelectDiv } from '@components/atoms';
import React, { ForwardedRef, forwardRef, useEffect, useState } from 'react';
import Arrow from '@constants/svg/arrow.svg';
import { useSpring, animated, config, useSpringRef, useChain } from '@react-spring/web';

export interface SelectProps {
  /**
   * 테마 선택
   * @default gray
   */
  theme?: 'gray' | 'orange';

  /**
   * 데이터 배열
   * @default []
   */
  data?: Array<dataTypes>;
}

export type dataTypes = {
  /**
   * 보이는 값
   */
  label: string;

  /**
   * 키 값
   */
  value: string;

  /**
   * 선택된 값 여부 (많을 경우 첫번째 true 선택)
   */
  selectValue?: boolean;
};

const defaultData: dataTypes = {
  label: '선택해주세요.',
  value: '',
  selectValue: true,
};

/**
 * select 대한 애니메이션 (svg)
 * @param open option 보이는 여부
 * @returns useSpring option
 */
const selectAnimation = (open: boolean) => {
  const { rotate } = useSpring({
    from: { rotate: 0 },
    to: { rotate: open ? 180 : 0 },
    config: config.stiff,
  });

  return { rotate };
};

/**
 * option 대한 애니메이션
 * @param open option 보이는 여부
 * @returns useSpring option
 */
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

  useChain(open ? [displayRef, opacityRef] : [opacityRef, displayRef]); // 애니메이션 동작 순서

  return { opacity, display, cursor };
};

/**
 * Select Component (molecules)
 */
export const Select = forwardRef((props: SelectProps, ref: ForwardedRef<HTMLInputElement>) => {
  const { theme = 'gray', data = [], ...prop } = props;

  const [open, setOpen] = useState<boolean>(false); // option 보이는 여부
  const [selectData, setSelectData] = useState<dataTypes>(defaultData); // 선택한 데이터

  const optionBorderColor = theme === 'gray' ? 'border-myGray' : 'border-myOrange';
  const svgColor = theme === 'gray' ? 'fill-myGray' : 'fill-myOrange';

  const { opacity, display, cursor } = optionAnimation(open);
  const { rotate } = selectAnimation(open);

  useEffect(() => {
    const select = data.find((key) => key.selectValue);

    if (select) setSelectData(select); // selectValue가 있다면 선택
    else data.unshift(defaultData); // selectValue가 없다면 data 배열 맨 앞 추가
  }, [data]);

  /**
   * select 영역 선택 시 open toggle
   */
  const onClickSelect = () => {
    setOpen(!open);
  };

  /**
   * select 영역 focus가 벗어날 시 open false
   */
  const onBlurSelect = () => {
    setOpen(false);
  };

  /**
   * option 선택 action
   * @param label 보이는 값
   * @param value 키 값
   */
  const onClickOption = (label: string, value: string) => () => {
    if (!open) return;

    setSelectData({ label: label, value: value });
  };

  /**
   * index first -> 'start', index last -> 'end'
   * @param index option 순서 index
   * @returns
   */
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
