package co.kr.sharek.project.domain;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "CM_POST_TAG")
@EqualsAndHashCode
@IdClass(PostTagId.class)
public class PostTag extends Base{
    @Id
    @ManyToOne
    @JoinColumn(name = "POST_SEQ", referencedColumnName = "SEQ")
    @Comment("순번 (POST)")
    private Post postSeq;

    @Id
    @ManyToOne
    @JoinColumn(name = "TAG_SEQ", referencedColumnName = "SEQ")
    @Comment("순번 (TAG_CATEGORY)")
    private TagCategory tagSeq;

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
class PostTagId implements Serializable {
    private Post postSeq;
    private String tagSeq;
}