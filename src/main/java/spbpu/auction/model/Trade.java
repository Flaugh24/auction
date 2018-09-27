package spbpu.auction.model;

import lombok.Data;

import java.util.Date;

@Data
public class Trade {

    private int id;

    private Lot lot;

    private User administrator;

    private Date date;
}
