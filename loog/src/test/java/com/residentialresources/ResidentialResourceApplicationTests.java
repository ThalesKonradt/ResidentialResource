package com.residentialresources;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ResidentialResourceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturn200() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/property/filter").param("hasPool", "true")
				.param("dormitoriesNumber", "3").contentType("application/json")).andExpect(status().isOk());
	}

}
