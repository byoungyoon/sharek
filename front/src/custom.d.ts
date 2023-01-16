declare module '*.svg' {
  import React = require('react');

  export const ReactComponent: React.FunctionComponent<React.SVGAttributes<SVGElement>>;

  export default ReactComponent;
}
