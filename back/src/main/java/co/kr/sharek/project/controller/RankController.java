package co.kr.sharek.project.controller;

import co.kr.sharek.project.repository.RankMappingRepository;
import co.kr.sharek.project.service.RankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
@RequiredArgsConstructor
public class RankController {
    private final RankService rankService;

    @GetMapping("/rank")
    public Page<RankMappingRepository> findAllBy(@PageableDefault(page = 0, size=20, sort="point", direction = Sort.Direction.DESC) Pageable pageable){
        return rankService.findAllBy(pageable);
    }
}
