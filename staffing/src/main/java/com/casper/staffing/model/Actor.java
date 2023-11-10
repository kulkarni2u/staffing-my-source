package com.casper.staffing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Table(name = "actors")
@Entity
@Getter @Setter
public class Actor extends BaseEntity {
    @Column(name = "external_app", nullable = false)
    @NonNull
    @NotNull
    private String externalApp;

    @Column(name = "external_id", nullable = false)
    @NonNull
    @NotNull
    private String externalId;
}
