package co.kr.sharek.project.service;

import co.kr.sharek.project.repository.RankMappingRepository;
import co.kr.sharek.project.repository.RankRepository;
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
    public Page<RankMappingRepository> findRank(Pageable pageable) {
        return rankRepository.findByOrderByPointDesc(pageable);
    }
}
