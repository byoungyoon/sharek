package co.kr.sharek.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "CM_WARNING_CATEGORY")
public class WarningCategory extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    @Comment("순번")
    private Long seq;

    @Column(name = "NAME", length = 30)
    @Comment("명칭")
    private String name;

    @CreationTimestamp
    @Column(name = "REG_DT")
    @Comment("생성 날짜")
    private LocalDateTime regDt;

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }
}
