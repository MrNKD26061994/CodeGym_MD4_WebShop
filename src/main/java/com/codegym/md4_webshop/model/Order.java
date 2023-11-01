package com.codegym.md4_webshop.model;

import com.codegym.md4_webshop.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    private Pay pay;

    private String address;

    private LocalDateTime time;
}
