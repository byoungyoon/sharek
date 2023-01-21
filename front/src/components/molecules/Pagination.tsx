import React, { useState, useEffect } from 'react';
import { PageDiv } from '@components/atoms/area/PageDiv';

export interface PaginationProps {
  theme?: 'gray' | 'orange';
  perPage: number;
  total: number;
  pageRangeDisplayed: number;
}

export const Pagination = (props: PaginationProps) => {
  const { theme = 'gray', perPage, total, pageRangeDisplayed, ...prop } = props;
  const [currentPage, setCurrentPage] = useState<number>(1); // 선택한 페이지
  const [totalPageArray, setTotalPageArray] = useState<number[][]>([[]]);
  // const [currentPageArray, setCurrentPageArray] = useState<number[]>([]);
  const [pageStep, setPageStep] = useState<number>(0);
  const endPage = Math.ceil(total / perPage);

  const onClickPage = (pageNum: number) => () => {
    setCurrentPage(pageNum);
  };

  useEffect(() => {
    const slicedPageArray = slicePageByLimit(endPage, pageRangeDisplayed);
    setTotalPageArray(slicedPageArray);
    // setCurrentPageArray(slicedPageArray[pageStep]);
  }, []);

  // 이전, 다음을 위한 페이지 배열 짜르기
  const slicePageByLimit = (endPage: number, limit: number) => {
    // 총 페이지 배열 생성
    const totalPageArray = Array(endPage)
      .fill(0)
      .map((_, idx) => idx + 1);

    // 페이지 짤라주기
    let initial = 0;
    return Array(Math.ceil(endPage / limit)) // 짜르는 등분만큼의 비어있는 2차원 배열생성
      .fill(0)
      .map(() => {
        /**
         * 비어있는 2차원 배열에 총 페이지 배열을 각각 넣어줌
         * ex) 총 7페이지를 최대 3개씩 보여준다
         *     1 2 3 / 4 5 6 / 7 이므로 3개의 배열이 필요함
         *     현재 array에는 아래와 같은 형식
         *     [[1,2,3,4,5,6,7] , [1,2,3,4,5,6,7] , [1,2,3,4,5,6,7]]
         *     slice 의 index를 바꿔주며 짜르기 위해 위의 initial 변수를 사용
         */
        const result = totalPageArray.slice(initial, initial + limit); //
        initial += limit;
        return result;
      });
  };

  const result = totalPageArray.map((array) =>
    array.map((pageNum) => (
      <PageDiv pageNum={pageNum} selected={pageNum === currentPage} onClick={onClickPage} theme={theme} />
    )),
  );

  return (
    <div>
      <div>{result}</div>
    </div>
  );
};
