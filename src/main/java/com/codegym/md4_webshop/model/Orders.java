package com.codegym.md4_webshop.model;

import com.codegym.md4_webshop.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    private Pay pay;

    private String address;

    private LocalDateTime time;
}
