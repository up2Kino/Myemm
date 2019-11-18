package com.zhijieketang.store.dao.imp;

import com.zhijieketang.db.core.JdbcTemplate;
import com.zhijieketang.store.dao.MerchantsDao;
import com.zhijieketang.store.domain.Merchants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantsDaoImpJdbc implements MerchantsDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Merchants findByPk(String pk) {

        List<Merchants> list = new ArrayList<Merchants>();
        String sql = "select id,name,password,address,phone,birthday from merchants where id=?";

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pk);
            return ps;
        }, rs -> {
            populate(list, rs);
        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Merchants> findAll() {

        List<Merchants> list = new ArrayList<Merchants>();
        String sql = "select id,name,password,address,phone,birthday from merchants";

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps;
        }, rs -> {
            populate(list, rs);
        });

        return list;
    }

    private void populate(List<Merchants> list, ResultSet rs) throws SQLException {
        Merchants merchants = new Merchants();
        merchants.setId(rs.getString("id"));
        merchants.setName(rs.getString("name"));
        merchants.setPassword(rs.getString("password"));
        merchants.setAddress(rs.getString("address"));
        merchants.setPhone(rs.getString("phone"));
        merchants.setBirthday(new Date(rs.getLong("birthday")));

        list.add(merchants);
    }

    @Override
    public void create(Merchants merchants) {

        String sql = "insert into merchants (id,name,password,address,phone,birthday) values (?,?,?,?,?,?)";

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 绑定参数
            ps.setString(1, merchants.getId());
            ps.setString(2, merchants.getName());
            ps.setString(3, merchants.getPassword());
            ps.setString(4, merchants.getAddress());
            ps.setString(5, merchants.getPhone());
            ps.setLong(6, merchants.getBirthday().getTime());

            return ps;
        });
    }

    @Override
    public void modify(Merchants merchants) {

        String sql = "update merchants set name=?,password=?,address=?,phone=?,birthday=? where id=?";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 绑定参数
            ps.setString(1, merchants.getName());
            ps.setString(2, merchants.getPassword());
            ps.setString(3, merchants.getAddress());
            ps.setString(4, merchants.getPhone());
            ps.setLong(5, merchants.getBirthday().getTime());
            ps.setString(6, merchants.getId());

            return ps;
        });
    }

    @Override
    public void remove(String pk) {
        String sql = "delete from merchants where id=?";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 绑定参数
            ps.setString(1, pk);
            return ps;
        });
    }
}
