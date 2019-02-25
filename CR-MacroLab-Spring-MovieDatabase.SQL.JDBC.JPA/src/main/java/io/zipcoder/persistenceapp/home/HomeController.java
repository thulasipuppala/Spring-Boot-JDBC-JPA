package io.zipcoder.persistenceapp.home;

import io.zipcoder.persistenceapp.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/homes", method = RequestMethod.GET)
    public List<Home> getAllHomes(){
        return homeService.findAll();
    }

    @RequestMapping(value = "/home/{id}/{address}/{houseNumber}", method = RequestMethod.POST)
    public Home createHome(@PathVariable Long id, @PathVariable String address, @PathVariable String houseNumber) {
        return homeService.createHome(id, address, houseNumber);
    }
}
