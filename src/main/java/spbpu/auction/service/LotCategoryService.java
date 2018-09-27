package spbpu.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbpu.auction.model.LotCategory;
import spbpu.auction.repository.LotCategoryRepository;

import java.util.List;

@Service
public class LotCategoryService {

    @Autowired
    private LotCategoryRepository lotCategoryRepository;

    public List<LotCategory> categories(){
        return lotCategoryRepository.findAll();
    }

}
