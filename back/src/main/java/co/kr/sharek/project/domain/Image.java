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
@Table(name = "CM_IMAGE")
public class Image extends Base {
    @Id
    @Column(name = "NAME", length = 50)
    @Comment("이미지 이름")
    private String name;

    @Column(name = "EXT", length = 5)
    @Comment("확장자")
    private String ext;

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
