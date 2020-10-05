package com.itstudent.entities.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name = "deleted")
    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
