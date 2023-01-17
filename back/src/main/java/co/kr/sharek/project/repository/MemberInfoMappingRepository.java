package co.kr.sharek.project.repository;

public interface MemberInfoMappingRepository {
    /**
     * Rank에 불러올 데이터
     * @return
     */
    Long getId();
    String getState();
    Long getPoint();
    String getNickname();
}
