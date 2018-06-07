package spbpu.auction.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "letter")
public class Letter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_letter_id")
    private Letter letter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id")
    private User userFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
    private User userTo;

    @Column(name = "content")
    private String content;
}

