package org.ccb.test.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.ccb.core.model.Address;
import org.ccb.core.model.Church;
import org.ccb.core.repository.ChurchRepository;
import org.ccb.property.rest.AppConfig;
import org.ccb.property.rest.controller.ChurchController;
import org.ccb.test.utils.TestUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class ChurchControllerTest {

	@Autowired
	private ChurchController controller;
	@Autowired
	private ChurchRepository repository;
	
	@Autowired
	private MappingJackson2HttpMessageConverter jacksonMessageConverter;
	@Autowired
	private PageableHandlerMethodArgumentResolver pageableArgumentResolver;
	
	private MockMvc restMock;
	
	private Church church;
	
	@PostConstruct
	public void setUp() {
		this.restMock = MockMvcBuilders.standaloneSetup(controller)
	            .setCustomArgumentResolvers(pageableArgumentResolver)
	            .setMessageConverters(jacksonMessageConverter).build();
	}
	
	@Before
	public void initClass() {
		church = new Church();
		church.setName("Central");
		church.setCode("130027");
		church.setImmobileType(1);
		
		Address address = new Address();
		
		address.setStreet("Zulmira de Novaes");
		address.setNumber(50);
		address.setNeighborhood("Bairro dos Novaes");
		address.setCep("58000000");
		
		church.setAddress(address);
	}
	
	@Test
	@Transactional(rollbackOn = Exception.class)
	public void createTest() throws IOException, Exception {
		int size = repository.findAll().size();
		
		restMock.perform(post("/church")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(church)))
				.andExpect(status().isOk());
		
		int newSize = repository.findAll().size();
		
		Assert.assertEquals(size + 1, newSize);
	}
}
