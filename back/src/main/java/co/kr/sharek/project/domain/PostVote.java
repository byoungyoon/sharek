package co.kr.sharek.project.domain;

import co.kr.sharek.common.constants.enums.PostVoteVarianceEnum;
import co.kr.sharek.common.util.enums.PostVoteVarianceConverter;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "CM_POST_VOTE")
@EqualsAndHashCode
@IdClass(PostVoteId.class)
public class PostVote extends Base{
    @Id
    @ManyToOne
    @JoinColumn(name = "POST_SEQ", referencedColumnName = "SEQ")
    @Comment("순번 (POST)")
    private Post postSeq;

    @Id
    @Column(name = "USER_ID", length = 15)
    @Comment("아이디 (USER, 외래키 X)")
    private String userId;

    @Convert(converter = PostVoteVarianceConverter.class)
    @Column(name = "VARIANCE")
    @Comment("업, 다운")
    private PostVoteVarianceEnum variance;

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

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
class PostVoteId implements Serializable {
    private Post postSeq;
    private String userId;
}
