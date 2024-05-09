package az.spring.blog.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_permission")
@Getter
@Setter
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fk_user_id")
    private Long fkUserId;

    @Column(name = "fk_permission_id")
    private Long fkPermissionId;

}