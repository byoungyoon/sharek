import { useSpring } from '@react-spring/web';

export const useOpacityAnimation = (open: boolean) => {
  const { opacity } = useSpring({
    from: { opacity: 0 },
    to: {
      opacity: open ? 1 : 0,
    },
  });

  return { opacity };
};
