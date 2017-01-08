package com.pigman.pro.service.impl;

import com.pigman.pro.domain.PnInfoDao;
import com.pigman.pro.domain.PnType;
import com.pigman.pro.service.PnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqiang on 2017/1/8.
 */
@Service
public class PnTypeServiceImpl implements PnTypeService {

    @Autowired
    private PnInfoDao pnInfoDao;

    @Override
    public List<PnType> getList() {
        return pnInfoDao.getList();
    }
}
