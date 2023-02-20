import React, { useState, useEffect, useMemo } from 'react';
import { PageDiv } from '@components/atoms/area/PageDiv';
import { PreNextDiv } from '@components/atoms/area/PreNextDiv';

export interface PaginationProps {
  theme?: 'gray' | 'orange';
  perPage?: number;
  total?: number;
  pageRangeDisplayed?: number;
  currentPage?: number;
  setCurrentPage?: React.Dispatch<React.SetStateAction<number>>;
}

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
      const slicedPage = totalPageArray.slice(initial, initial + limit); //
      initial += limit;
      return slicedPage;
    });
};

export const Pagination = (props: PaginationProps) => {
  const [sample, setSample] = useState(1); // 스토리북을 위한 샘플

  const {
    theme = 'gray',
    perPage = 1,
    total = 1,
    pageRangeDisplayed = 5,
    currentPage = sample,
    setCurrentPage = setSample,
  } = props;

  const [totalPageArray, setTotalPageArray] = useState<number[][]>([[]]);
  const [currentPageArray, setCurrentPageArray] = useState<number[]>([]);

  const endPage = useMemo(() => (perPage < 1 || total < 1 ? 1 : Math.ceil(total / perPage)), [perPage, total]);
  const limit = useMemo(() => (pageRangeDisplayed < 1 ? 5 : pageRangeDisplayed), [pageRangeDisplayed]);

  const onClickPage = (pageNum: number) => () => {
    setCurrentPage(pageNum);
  };

  useEffect(() => {
    const slicedPageArray = slicePageByLimit(endPage, limit);

    setTotalPageArray(slicedPageArray);
    setCurrentPageArray(slicedPageArray[0]);
  }, [endPage, limit]);

  // 이전 다음 btn, 페이지 배열
  const preBtnFn = () => () => {
    if (currentPageArray.length === 1) {
      const pageIndex = Math.floor(currentPageArray[0] / limit) - 1;
      setCurrentPageArray(totalPageArray[pageIndex - 1]);
      return;
    }
    const pageIndex = Math.floor(currentPageArray[0] / limit);
    setCurrentPageArray(totalPageArray[pageIndex - 1]);
  };

  const nextBtnFn = () => () => {
    if (currentPageArray.length === 1) {
      const pageIndex = Math.floor(currentPageArray[0] / limit) - 1;
      setCurrentPageArray(totalPageArray[pageIndex + 1]);
      return;
    }
    const pageIndex = Math.floor(currentPageArray[0] / limit);
    setCurrentPageArray(totalPageArray[pageIndex + 1]);
  };

  const result = currentPageArray.map((pageNum) => (
    <PageDiv key={pageNum} pageNum={pageNum} selected={pageNum === currentPage} onClick={onClickPage} theme={theme} />
  ));

  return (
    <div className="flex justify-center m-7">
      {currentPageArray[0] !== 1 && <PreNextDiv label="이전" onClick={preBtnFn} />}
      {result}
      {currentPageArray[currentPageArray.length - 1] !== endPage && <PreNextDiv label="다음" onClick={nextBtnFn} />}
    </div>
  );
};
