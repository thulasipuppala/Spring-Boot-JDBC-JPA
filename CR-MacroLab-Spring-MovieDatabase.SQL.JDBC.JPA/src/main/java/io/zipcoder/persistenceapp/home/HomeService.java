package io.zipcoder.persistenceapp.home;

import io.zipcoder.persistenceapp.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HomeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public HomeService() {
    }

    public List<Home> findAll(){
        String sql = "Select * from Home";
        List<Home> homes = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row : rows){
            Home h = new Home();
            h.setId(Long.parseLong(String.valueOf(row.get("id"))));
            h.setAddress((String) row.get("address"));
            h.setHomenumber((String) row.get("homenumber"));
            homes.add(h);
        }
        return homes;
    }

    public Home createHome(Long id, String address, String houseNumber) {
        this.jdbcTemplate.update("insert into home (id, address, homenumber) values (?, ?, ?)",
                new Object[] {id, address, houseNumber});
        return new Home(id, address, houseNumber);
    }
}
