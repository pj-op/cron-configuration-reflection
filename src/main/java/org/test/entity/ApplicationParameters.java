package org.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "application_parameter")
public class ApplicationParameters {
    @Id
    @Column(name = "prop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appParamId;
    private String name;
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApplicationParameters that = (ApplicationParameters) o;
        return appParamId != null && Objects.equals(appParamId, that.appParamId);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

