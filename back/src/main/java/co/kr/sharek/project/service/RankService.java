package co.kr.sharek.project.service;

import co.kr.sharek.config.security.entity.Member;
import co.kr.sharek.project.dto.RankResponseDto;
import co.kr.sharek.project.repository.RankMappingRepository;
import co.kr.sharek.project.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static co.kr.sharek.common.exception.ExceptionCode.NOT_FOUND_USER;

@Service
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;

    @Transactional(readOnly = true)
    public Page<RankMappingRepository> findRank(String nickname, Pageable pageable) {
        if(nickname.isBlank()){
            return rankRepository.findByOrderByPointDesc(pageable);
        }else{
            return rankRepository.findByNicknameContainingOrderByPointDesc(nickname, pageable);
        }
    }

//    @Transactional(readOnly = true)
//    public RankResponseDto myRankByNickname(String nickname){
//       RankMappingRepository myRank = rankRepository.findByNicknameOrderByPointDesc(nickname).orElseThrow(NOT_FOUND_USER::getException);
//
//        return RankResponseDto.from(myRank);
//    }
}
