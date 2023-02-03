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
@Table(name = "CM_WARNING")
public class Warning extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Comment("순번")
    private Long seq;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @Comment("아이디 (USER)")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_SEQ", referencedColumnName = "SEQ")
    @Comment("순번 (CATEGORY)")
    private WarningCategory categorySeq;

    @Column(name = "REASON", nullable = false)
    @Comment("사유")
    private String reason;

    @CreationTimestamp
    @Column(name = "REG_DT")
    @Comment("생성 날짜")
    private LocalDateTime retDt;

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
