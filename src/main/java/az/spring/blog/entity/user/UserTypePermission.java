package az.spring.blog.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_type_permission")
@Getter
@Setter
public class UserTypePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fk_user_type_id")
    private Long fkUserTypeId;

    @Column(name = "fk_permission_id")
    private Long fkPermissionId;

}