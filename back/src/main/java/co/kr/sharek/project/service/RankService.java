package co.kr.sharek.project.service;

import co.kr.sharek.project.domain.Rank;
import co.kr.sharek.project.domain.User;
import co.kr.sharek.project.dto.RankResponseDto;
import co.kr.sharek.project.repository.RankRepository;
import co.kr.sharek.project.repository.RankSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;

    @Transactional(readOnly = true)
    public Page<RankSummary> findNickname (String nickname, Pageable pageable) {
        Page<RankSummary> rank = rankRepository.findByNickname(nickname, pageable);

        return rank;
    }

    @Transactional(readOnly = true)
    public Page<RankSummary> findAllRank (Pageable pageable) {
        Page<RankSummary> rank = rankRepository.findByOrderByPointDesc(pageable);

        return rank;
    }

    //TODO
    @Transactional(readOnly = true)
    public List<String> findMyRank(){

        // 로그인 한 정보에서 추출.. 이러면 랭킹순번은..?
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User)principal;

        List<String> result = Arrays.asList(
                user.getName(),
                user.getNickname(),
                user.getImg(),
                user.getProfill(),
                user.getTeam(),
                String.valueOf(user.getPoint()));

        return result;
    }
}
