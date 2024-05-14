package org.test.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.test.request.CommonRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@Entity
@ToString
@Builder
@Table(name = "actor")
@NoArgsConstructor
@AllArgsConstructor
public class ActorDAO implements CommonRequest, Serializable {
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ActorDAO actorDAO = (ActorDAO) o;
        return getActorId() != null && Objects.equals(getActorId(), actorDAO.getActorId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
