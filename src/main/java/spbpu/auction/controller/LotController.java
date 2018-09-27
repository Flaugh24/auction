package spbpu.auction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spbpu.auction.dto.LotDTO;
import spbpu.auction.model.Lot;
import spbpu.auction.service.LotCategoryService;
import spbpu.auction.service.LotService;

import java.util.List;

@Controller
@RequestMapping(value = "/lots")
public class LotController {

    private final Logger LOG = LoggerFactory.getLogger(LotController.class);

    @Autowired
    private LotService lotService;
    @Autowired
    private LotCategoryService lotCategoryService;

    @GetMapping(value = "/")
    public ModelAndView lots(ModelMap modelMap) {

        final List<Lot> lots = lotService.lots();
        modelMap.addAttribute("lots", lots);

        return new ModelAndView("lots", modelMap);
    }

    @GetMapping(value = "/add")
    public ModelAndView getAddLot(ModelMap modelMap){

        modelMap.addAttribute("lot", new LotDTO());
        modelMap.addAttribute("categories", lotCategoryService.categories());

        return new ModelAndView("addLot",  modelMap);
    }


    @PostMapping(value = "/add2")
    public String saveLot(@ModelAttribute("lot") LotDTO dto, ModelMap modelMap){

        LOG.info("asdfasdfasdfasdf");

        if(!lotService.saveLot(dto)){
            modelMap.addAttribute("lot", dto);
            return "addLot";
        }

        return "redirect:/lots/";
    }

}
