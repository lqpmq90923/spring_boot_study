package com.pigman.pro.domain.impl;

import com.pigman.pro.domain.PnInfoDao;
import com.pigman.pro.domain.PnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by liqiang on 2017/1/8.
 */
@Repository
public class PnInfoDaoImp implements PnInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PnType> getList() {
        return jdbcTemplate.query("select * from tb_pn_type", new PnTypeRowMapper());
    }
}
class PnTypeRowMapper implements RowMapper<PnType> {

    @Override
    public PnType mapRow(ResultSet rs, int rowNum) throws SQLException {
        PnType info = new PnType();
        info.setId(rs.getLong("id"));
        info.setComments(rs.getString("comments"));
        return info;
    }
}