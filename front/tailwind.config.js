const colors = require('tailwindcss/colors');

module.exports = {
  content: ['./src/**/*.{js,jsx,ts,tsx}'],
  darkMode: 'class',
  theme: {
    spacing: {
      0.5: '0.125rem',
      1: '0.25rem',
      1.5: '0.375rem',
      2: '0.5rem',
      2.5: '0.625rem',
      3: '0.75rem',
      3.5: '0.875rem',
      4: '1rem',
      5: '1.25rem',
      6: '1.5rem',
      7: '1.75rem',
      8: '2rem',
      9: '2.25rem',
      10: '2.5rem',
      sm: '360px',
      md: '480px',
      lg: '640px',
    },
    minWidth: {
      smBtn: '70px',
    },
    colors: {
      ...colors,
      myGray: {
        DEFAULT: '#BCBCBC',
        light: '#D9D9D9',
      },
      myOrange: {
        DEFAULT: '#FDB728',
        light: '#FFD174',
        pale: '#FFECC6',
      },
    },
    fontFamily: {
      myBold: 'NotoKR-Bold',
      myMed: 'NotoKR-Medium',
      myLight: 'NotoKR-Light',
    },
    screens: {
      tablet: { max: '640px' },
      laptop: { min: '640px', max: '1280px' },
      desktop: { min: '1280px' },
    },
  },
  plugins: [],
};
