import { create } from 'zustand';

export interface IAlert {
  open: boolean;
  type: AlertType;
  message: string;
}

export enum AlertType {
  SUCCESS = 'success',
  ERROR = 'error',
  WARNING = 'warning',
  INFO = 'info',
}

interface IUseAlert extends IAlert {
  setOpen: (props: IAlert) => void;
}

export const useAlertDefault = {
  open: false,
  type: AlertType.SUCCESS,
  message: '',
};

export const useAlert = create<IUseAlert>((set) => ({
  ...useAlertDefault,
  setOpen: (props: IAlert) => set(() => ({ open: props.open, type: props.type, message: props.message })),
}));

export const useAlertOpen = () => {
  const { setOpen } = useAlert();

  const setAlert = (sType: AlertType, sMessage: string) => {
    const alert: IAlert = {
      open: true,
      type: sType,
      message: sMessage,
    };

    return alert;
  };

  return { setOpen, setAlert };
};
