package co.kr.sharek.project.service;

import co.kr.sharek.project.dto.common.ReqPageDto;
import co.kr.sharek.project.dto.user.ReqRankDto;
import co.kr.sharek.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RankService {
    private final UserRepository userRepository;
    private final PageService pageService;


    @Transactional(readOnly = true)
    public Map<String, Object> getUserRank (ReqRankDto reqRankDto) {
        if (!userRepository.existsById(reqRankDto.getId())) {
            throw new RuntimeException("회원 정보를 찾을 수 없습니다.");
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("user", userRepository.findToUserRank(reqRankDto));

        return resultMap;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getRankAll (ReqPageDto reqPageDto) {
        return pageService.setPaging(userRepository, reqPageDto);
    }



}
