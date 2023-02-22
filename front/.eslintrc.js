module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  extends: [
    'airbnb',
    'airbnb-typescript',
    'prettier',
    'plugin:react/recommended', // eslint-plugin-react에서 추천하는 리액트 린팅 설정
    'plugin:@typescript-eslint/recommended', // @typescript-eslint/recommended의 추천 룰 사용
    'plugin:prettier/recommended',
    'plugin:storybook/recommended',
  ],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 'latest',
    sourceType: 'module',
    project: ['tsconfig.json'],
    tsconfigRootDir: __dirname,
  },
  plugins: ['@typescript-eslint', 'prettier'],
  rules: {
    'linebreak-style': 0, // LF, CRLF 차이 제거
    'import/prefer-default-export': 0, // export default 권장 제거
    'prettier/prettier': 0, // prettier 충돌 방지
    'import/no-unresolved': 0, // path 확정 권장 제거
    'import/no-extraneous-dependencies': 0, // 테스트 또는 개발환경을 구성하는 파일에서는 devDependency 사용을 허용
    'react/jsx-filename-extension': [2, { extensions: ['.js', '.jsx', '.ts', '.tsx'] }], // 파일 이름 허용
    'jsx-a11y/no-noninteractive-element-interactions': 0, // 비대칭형 태그에 action 허용
    'no-unused-vars': 'warn', // 안 쓰는 변수 경고
    '@typescript-eslint/no-var-requires': 0, // 인터페이스의 안 쓰는 변수는 허용
    'react/function-component-definition': [2, { namedComponents: 'arrow-function' }], // 화살표 함수로 통일
    'react/jsx-props-no-spreading': 0, // spread 연산자 허용
    'react/require-default-props': 0,
    'jsx-a11y/click-events-have-key-events': 0,
    'class-methods-use-this': 0,
    'no-param-reassign': 0,
  },
  ignorePatterns: ['.eslintrc.js'],
};
