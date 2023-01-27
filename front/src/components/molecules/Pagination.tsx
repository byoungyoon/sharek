import React, { useState, useEffect, SetStateAction, Dispatch } from 'react';
import { PageDiv } from '@components/atoms/area/PageDiv';
import { PreNextDiv } from '@components/atoms/area/PreNextDiv';

export interface PaginationProps {
  theme?: 'gray' | 'orange';
  perPage: number;
  total: number;
  pageRangeDisplayed: number;
  currentPage: number;
  setCurrentPage: React.Dispatch<React.SetStateAction<number>>;
}

export const Pagination = (props: PaginationProps) => {
  const { theme = 'gray', perPage, total, pageRangeDisplayed, currentPage = 1, setCurrentPage, ...prop } = props;
  // const [currentPage, setCurrentPage] = useState<number>(1); // 선택한 페이지
  const [totalPageArray, setTotalPageArray] = useState<number[][]>([[]]);
  const [currentPageArray, setCurrentPageArray] = useState<number[]>([]);
  const endPage = Math.ceil(total / perPage);

  const onClickPage = (pageNum: number) => () => {
    setCurrentPage(pageNum);
  };

  useEffect(() => {
    const slicedPageArray = slicePageByLimit(endPage, pageRangeDisplayed);
    setTotalPageArray(slicedPageArray);
    setCurrentPageArray(slicedPageArray[0]);
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
        const slicedPage = totalPageArray.slice(initial, initial + limit); //
        initial += limit;
        return slicedPage;
      });
  };

  // 이전 다음 btn, 페이지 배열
  const preBtnFn = () => () => {
    const pageIndex = Math.floor(currentPageArray[0] / pageRangeDisplayed);
    setCurrentPageArray(totalPageArray[pageIndex - 1]);
  };

  const nextBtnFn = () => () => {
    const pageIndex = Math.floor(currentPageArray[0] / pageRangeDisplayed);
    setCurrentPageArray(totalPageArray[pageIndex + 1]);
  };

  const result = currentPageArray.map((pageNum) => (
    <PageDiv pageNum={pageNum} selected={pageNum === currentPage} onClick={onClickPage} theme={theme} />
  ));

  return (
    <div className="flex justify-center">
      {currentPageArray[0] != 1 && <PreNextDiv label={'이전'} theme={theme} onClick={preBtnFn} />}
      {result}
      {currentPageArray[currentPageArray.length - 1] != endPage && (
        <PreNextDiv label={'다음'} theme={theme} onClick={nextBtnFn} />
      )}
    </div>
  );
};
