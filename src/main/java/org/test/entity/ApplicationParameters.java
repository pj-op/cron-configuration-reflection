package org.test.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
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

