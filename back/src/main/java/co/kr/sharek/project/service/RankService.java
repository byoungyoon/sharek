package co.kr.sharek.project.service;

import co.kr.sharek.project.dto.common.ReqPageDto;
import co.kr.sharek.project.repository.RankRepository;
import co.kr.sharek.project.repository.RankSummary;
import co.kr.sharek.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;
    private final UserRepository userRepository;
    private final PageService pageService;

    @Transactional(readOnly = true)
    public Page<RankSummary> getSearchNickname (String nickname, Pageable pageable) {
        Page<RankSummary> rank = rankRepository.getSearchNickname(nickname, pageable);

        return rank;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getRankAll (ReqPageDto reqPageDto) {
        return pageService.setPaging(userRepository, reqPageDto);
    }
}
