import React from 'react';

import { CardDiv, Title } from '@components/atoms';
import Success from '@constants/svg/success.svg';
import Error from '@constants/svg/error.svg';
import Info from '@constants/svg/info.svg';
import Warning from '@constants/svg/warning.svg';
import Close from '@constants/svg/close.svg';
import { useAlert, useAlertDefault } from '@utils/index';
import { animated } from '@react-spring/web';
import { useOpacityAnimation } from '@utils/useSpring';

/**
 * Alert molecules
 */
export const Alert = () => {
  const { open, type, message, setOpen } = useAlert();
  const { opacity } = useOpacityAnimation(open);

  const onClickClose = () => {
    setOpen(useAlertDefault);
  };

  return open ? (
    <animated.div style={{ opacity }}>
      <div className="fixed top-0 left-0 w-full h-full bg-gray-200/50">
        <CardDiv className="fixed top-5 left-1/2 translate-x-[-50%]">
          <div className="flex max-w-lg laptop:max-w-full tablet:max-w-full">
            <div className="p-2.5">
              {type === 'success' && <Success className="fill-green-500" width={24} height={24} />}
              {type === 'error' && <Error className="fill-red-500" width={24} height={24} />}
              {type === 'warning' && <Warning className="fill-yellow-500" width={24} height={24} />}
              {type === 'info' && <Info className="fill-sky-500" width={24} height={24} />}
            </div>
            <div>
              <div className="margin-0 leading-none mb-1.5">
                {type === 'success' && (
                  <Title className="text-green-500" label="Success" fontStyle="h2" fontWeight="medium" />
                )}
                {type === 'error' && (
                  <Title className="text-red-500" label="Error" fontStyle="h2" fontWeight="medium" />
                )}
                {type === 'warning' && (
                  <Title className="text-yellow-500" label="Warning" fontStyle="h2" fontWeight="medium" />
                )}
                {type === 'info' && <Title className="text-sky-500" label="Info" fontStyle="h2" fontWeight="medium" />}
              </div>
              <div className="break-all">
                <Title className="text-slate-400" label={message} fontStyle="h3" />
              </div>
            </div>
            <div className="p-2.5">
              <Close className="fill-myGray cursor-pointer" width={24} height={24} onClick={onClickClose} />
            </div>
          </div>
        </CardDiv>
      </div>
    </animated.div>
  ) : (
    <div className="hidden" />
  );
};
