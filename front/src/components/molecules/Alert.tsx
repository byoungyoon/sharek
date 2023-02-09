import React from 'react';

import { CardDiv, Title } from '@components/atoms';
import Success from '@constants/svg/success.svg';
import Error from '@constants/svg/error.svg';
import Info from '@constants/svg/info.svg';
import Warning from '@constants/svg/warning.svg';
import Close from '@constants/svg/close.svg';

interface AlertProps {
  /**
   * 들어갈 text
   */
  children: string;

  /**
   * Alert 타입
   */
  type: 'success' | 'error' | 'warning' | 'info';
}

/**
 * Alert (molecules)
 */
export const Alert = (props: AlertProps) => {
  const { type, children } = props;

  return (
    <CardDiv>
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
            {type === 'error' && <Title className="text-red-500" label="Error" fontStyle="h2" fontWeight="medium" />}
            {type === 'warning' && (
              <Title className="text-yellow-500" label="Warning" fontStyle="h2" fontWeight="medium" />
            )}
            {type === 'info' && <Title className="text-sky-500" label="Info" fontStyle="h2" fontWeight="medium" />}
          </div>
          <div className="break-all">
            <Title className="text-slate-400" label={children} fontStyle="h3" />
          </div>
        </div>
        <div className="p-2.5">
          <Close className="fill-myGray" width={24} height={24} />
        </div>
      </div>
    </CardDiv>
  );
};
