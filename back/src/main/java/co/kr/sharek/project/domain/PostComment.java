package co.kr.sharek.project.domain;

import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "CM_POST_COMMENT")
@EqualsAndHashCode
@IdClass(PostCommentId.class)
public class PostComment extends Base{
    @Id
    @ManyToOne
    @JoinColumn(name = "POST_SEQ", referencedColumnName = "SEQ")
    @Comment("순번 (POST)")
    private Post postSeq;

    @Id
    @Column(name = "USER_ID", length = 15)
    @Comment("아이디 (USER, 외래키 X)")
    private String userId;

    @Column(name = "CONTENT")
    @Comment("내용")
    private String content;

    @CreationTimestamp
    @Column(name = "REG_DT")
    @Comment("생성 날짜")
    private LocalDateTime regDt;

    @UpdateTimestamp
    @Column(name = "MOD_DT", nullable = false)
    @Comment("수정 날짜")
    private LocalDateTime modDt;

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
class PostCommentId implements Serializable{
    private Post postSeq;
    private String userId;
}


