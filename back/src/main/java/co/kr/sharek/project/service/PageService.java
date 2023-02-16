package co.kr.sharek.project.service;

import co.kr.sharek.project.dto.common.ReqPageDto;
import co.kr.sharek.project.repository.PageRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PageService<T extends PageRepositoryCustom> {
    public Map<String, Object> setPaging(T repository, ReqPageDto reqPageDto){
        List<Object> list = new ArrayList<>();

        reqPageDto.setCurrentPage((reqPageDto.getCurrentPage() - 1) * reqPageDto.getPerPage());
        repository.findPaging(reqPageDto).forEach((datum) -> {
            list.add(datum);
        });

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", list);
        resultMap.put("total", repository.findTotal(reqPageDto));

        return resultMap;
    }
}
