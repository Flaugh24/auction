package spbpu.auction.model;

import lombok.Data;

@Data
public class Letter {

    private int id;

    private Letter letter;

    private User userFrom;

    private User userTo;

    private String content;
}

