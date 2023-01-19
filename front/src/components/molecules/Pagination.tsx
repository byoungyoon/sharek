import React, { useState } from 'react';
import { PageDiv } from '@components/atoms/area/PageDiv';

export interface PaginationProps {
  theme?: 'gray' | 'orange';
  perPage: string;
  total: string;
}

export const Pagination = (props: PaginationProps) => {
  const { theme = 'gray', perPage, total, ...prop } = props;
  const [currentPage, setCurrentPage] = useState<number>(1); // 선택한 페이지
  const endPage = Math.ceil(parseInt(total) / parseInt(perPage));
  const onclickPage = (index: number) => () => {
    setCurrentPage(index);
  };

  let pageNumbers: Array<number> = [];

  for (let i = 1; i <= endPage; i++) {
    pageNumbers.push(i);
  }

  const result = pageNumbers.map((pageNum) => (
    <span>
      <PageDiv pageNum={pageNum} selected={pageNum === currentPage} onClick={onclickPage} theme={theme} />
    </span>
  ));

  return <div>{result}</div>;
};
