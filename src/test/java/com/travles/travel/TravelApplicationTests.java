package com.travles.travel;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travles.travel.entity.Province;
import com.travles.travel.entity.User;
import com.travles.travel.service.ProvinceService;
import com.travles.travel.service.UserService;

@SpringBootTest
class TravelApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private ProvinceService provinceService;
	@Test
    public void testSave() {
    	User user=new User();
    	user.setUsername("jiuyu");
    	user.setPassword("jiuyu123");
    	user.setEmail("jiuyu@163.com");
    	userService.register(user);
    }
	@Test
	public void testSelectProvinces() {
		List<Province> provinces=provinceService.findProviceByPage(0, 10);
		int total=provinceService.findTotalProvince();
		provinces.forEach(province->{
			System.out.println(province);
		});
		System.out.println(total);
	}

}
