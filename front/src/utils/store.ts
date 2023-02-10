import { create } from 'zustand';

export interface IAlert {
  open: boolean;
  type: 'success' | 'error' | 'warning' | 'info';
  message: string;
}

interface IUseAlert extends IAlert {
  setOpen: (props: IAlert) => void;
}

export const useAlertDefault: IAlert = {
  open: false,
  type: 'success',
  message: '',
};

export const useAlert = create<IUseAlert>((set) => ({
  ...useAlertDefault,
  setOpen: (props: IAlert) => set(() => ({ open: props.open, type: props.type, message: props.message })),
}));
