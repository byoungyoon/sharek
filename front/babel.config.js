module.exports = {
  presets: [
    '@babel/preset-react',
    [
      '@babel/preset-typescript',
      {
        allExtensions: true,
        isTSX: true,
      },
    ],
    [
      '@babel/preset-env',
      {
        targets: {
          chrome: '58',
          ie: 11,
        },
        useBuiltIns: 'usage',
        corejs: 3,
      },
    ],
  ],
};
