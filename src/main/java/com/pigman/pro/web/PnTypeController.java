package com.pigman.pro.web;

import com.pigman.pro.domain.PnType;
import com.pigman.pro.service.PnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liqiang on 2017/1/8.
 */
@Controller
@RequestMapping("/pntype")
public class PnTypeController {

    @Autowired
    private PnTypeService pnTypeService;

    @RequestMapping("/getlist")
    public String getList(Model model){
        List<PnType> pnTypes = pnTypeService.getList();
        model.addAttribute("list", pnTypes);
        return "pn_type_list";
    }
}
