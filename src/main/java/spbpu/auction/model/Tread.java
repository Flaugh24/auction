package spbpu.auction.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "trade")
public class Tread {

    @Id
    @Column(name = "trade")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot")
    private Lot lot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private User administrator;

    @Column(name = "date")
    private Date date;
}
