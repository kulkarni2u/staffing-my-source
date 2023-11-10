package com.casper.staffing.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Validated
@Table(name = "template_files")
@EqualsAndHashCode(callSuper = true, of = {"name"})
public class TemplateFile extends BaseEntity {
    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "ready")
    private Boolean ready;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("templateId")
    @JoinColumn(name = "template_id", foreignKey = @ForeignKey(name = "FK_template_template_file"))
    private Template template;
}
