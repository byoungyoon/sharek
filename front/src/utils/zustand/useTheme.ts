import { create } from 'zustand';

export interface ITheme {
  theme: ThemeType;
}

export enum ThemeType {
  LIGHT = 'light',
  DARK = 'dark',
}

interface IUseTheme extends ITheme {
  setTheme: (props: ITheme) => void;
}

export const useTheme = create<IUseTheme>((set) => ({
  theme: ThemeType.LIGHT,
  setTheme: (props: ITheme) => set(() => ({ theme: props.theme })),
}));
