package spbpu.auction.dto;

import lombok.Data;

@Data
public class LotDTO {
    public String name;
    public String descr;
    public Double bid;
    public Integer categoryId;

}
