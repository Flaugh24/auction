package spbpu.auction.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lot_category")
public class LotCategory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

}
