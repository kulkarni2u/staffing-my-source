package com.casper.staffing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true, of = {"visible"})
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Validated
@Table(name = "templates")
public class Template extends BaseEntity {
    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "visible", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean visible;

    @Column(name = "notes")
    @Size(max = 3000)
    private String notes;

    @OneToMany(
            mappedBy = "template", cascade = { CascadeType.PERSIST, CascadeType.MERGE},
            targetEntity = TemplateFile.class,
            fetch = FetchType.LAZY
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<TemplateFile> templateFiles;
}
