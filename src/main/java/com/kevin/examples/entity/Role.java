package com.kevin.examples.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 11/1/2016.
 */
@Data
@ToString(exclude = "userList")
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roleList", fetch = FetchType.LAZY)
    private List<User> userList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permission",
            uniqueConstraints = @UniqueConstraint(columnNames={"role_id","permission_id"}),
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<Permission> permissionList;

}
