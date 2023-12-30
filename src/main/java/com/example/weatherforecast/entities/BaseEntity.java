package com.example.weatherforecast.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "weatherforecast.id_sequence", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Version
    @Column(name = "DATABASE_VERSION", nullable = false)
    private long databaseVersion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", updatable = false, nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @PrePersist
    private void setUpdateDate() {
        updateDate = LocalDateTime.now();
    }
}
