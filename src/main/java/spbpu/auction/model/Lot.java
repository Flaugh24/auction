package spbpu.auction.model;

import lombok.Data;

import java.util.Date;

@Data
public class Lot {

    private int id;

    private String name;

    private String description;

    private double bid;

    private Date startDate = new Date();

    private Date finishDate;

    private Integer categoryId;

    private Integer sellerId;

    private Integer buyerId;

    private Boolean status;
}
