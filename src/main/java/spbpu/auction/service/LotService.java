package spbpu.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.auction.dto.LotDTO;
import spbpu.auction.model.Lot;
import spbpu.auction.repository.LotRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LotService {

    @Autowired
    private LotRepository lotRepository;

    public List<Lot> lots(){
        return lotRepository.findAll();
    }

    public boolean saveLot(LotDTO lotDTO){


        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 30);
        dt = c.getTime();

        final Lot lot = new Lot();
        lot.setName(lotDTO.name);
        lot.setDescription(lotDTO.descr);
        lot.setCategoryId(lotDTO.categoryId);
        lot.setBid(lotDTO.bid);
        lot.setFinishDate(dt);


        return lotRepository.save(lot);
    }
}
