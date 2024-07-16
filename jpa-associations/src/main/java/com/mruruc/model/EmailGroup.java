package com.mruruc.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "email_groups", schema = "public")
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_groups_pk_sequence_generator")
    @SequenceGenerator(name = "email_groups_pk_sequence_generator", allocationSize = 1)
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "group_name", columnDefinition = "VARCHAR", length = 100)
    private String groupName;
    @ManyToMany
    @JoinTable(name = "email_group_subscriptions",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> groupMembers;

    public EmailGroup(){}

}
