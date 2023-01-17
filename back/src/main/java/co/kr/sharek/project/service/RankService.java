package co.kr.sharek.project.service;

import co.kr.sharek.project.dto.RankRequestDto;
import co.kr.sharek.project.dto.RankResponseDto;
import co.kr.sharek.project.repository.MemberInfoMappingRepository;
import co.kr.sharek.project.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankService {
    private final RankRepository rankRepository;

    @Transactional(readOnly = true)
    public List<RankRequestDto> findAllBy() {
        List<MemberInfoMappingRepository> members = rankRepository.findAllBy();

        return members.stream()
                .map(RankResponseDto::from)
                .collect(Collectors.toList());
    }
}
