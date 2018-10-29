package com.rockonengin;

import com.rockonengin.model.entity.Company;
import com.rockonengin.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockonenginWebApplicationTests {

	@Autowired
	private CompanyService companyService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSelectCompany(){

		Company company = companyService.getCompany(1);

		Assert.notNull(company);
	}

}
