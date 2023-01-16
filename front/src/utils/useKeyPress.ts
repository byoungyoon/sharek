import { useEffect, useState } from 'react';

export const useKeyPress = (targetKey: string) => {
  const [keyPressed, setKeyPress] = useState<boolean>(false);

  const downHandler = (event: KeyboardEvent) => {
    if (event.key === targetKey) setKeyPress(true);
  };

  const upHandler = (event: KeyboardEvent) => {
    if (event.key === targetKey) setKeyPress(false);
  };

  useEffect(() => {
    window.addEventListener('keydown', downHandler);
    window.addEventListener('keyup', upHandler);

    return () => {
      window.removeEventListener('keydown', downHandler);
      window.removeEventListener('keyup', upHandler);
    };
  }, []);

  return keyPressed;
};
