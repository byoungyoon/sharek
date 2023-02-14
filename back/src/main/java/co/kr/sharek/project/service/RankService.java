package co.kr.sharek.project.service;

import co.kr.sharek.project.repository.RankRepository;
import co.kr.sharek.project.repository.RankSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;

    @Transactional(readOnly = true)
    public Page<RankSummary> getSearchNickname (String nickname, Pageable pageable) {
        Page<RankSummary> rank = rankRepository.getSearchNickname(nickname, pageable);

        return rank;
    }

    @Transactional(readOnly = true)
    public Page<RankSummary> getRankingList (Pageable pageable) {

        return rankRepository.getRankingList(pageable);
    }
}
