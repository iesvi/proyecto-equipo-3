package com.Equipo3.Backend.Shared.Dominio.Audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

public class AuditableEntity {

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar auditCreatedDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar auditLastModifiedDate;

    @Column(nullable = false, updatable = false)
    @CreatedBy
    private String auditCreateBy;

    @LastModifiedBy
    private String auditlLastModifiedBy;
}