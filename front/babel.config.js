module.exports = {
  presets: [
    '@babel/preset-react',
    '@babel/preset-typescript',
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
