package org.ccb.test.repositories;

import java.util.List;

import org.ccb.core.model.Church;
import org.ccb.core.repository.ChurchRepository;
import org.ccb.property.rest.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
public class ChurchRepositoryTest {
	
	@Autowired
	private ChurchRepository repository;
	
	@Test
	public void updateTest() {
		Church church = new Church();
		church.setId(1L);
		church.setName("Central de João Pessoa 2");
		
		repository.update(church);
	}
	
	@Test
	public void logicalRemove() {
		Church church = new Church();
		
		repository.logicalDelete(1L);
		
		List<Church> result = repository.list();
		
		Assert.assertEquals(0, result.size());
	}

}
