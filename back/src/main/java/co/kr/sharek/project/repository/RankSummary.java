package co.kr.sharek.project.repository;

public interface RankSummary {
    /**
     * Rank에 불러올 데이터
     * @return
     */
    String getId();
    String getName();
    String getNickname();
    String getImg();
    String getProfile();
    String getTeam();
    Long getPoint();
}
