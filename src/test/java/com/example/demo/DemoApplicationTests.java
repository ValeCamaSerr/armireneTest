package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controllers.MathController;
import com.example.demo.services.MathService;

@SpringBootTest
class DemoApplicationTests {
	private MockMvc mockMvc;

	@InjectMocks
	private MathController lookupController;

	@Mock
	MathService mathService;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(lookupController).build();
		this.mathService = new MathService();
	}

	@Test
	public void testSumatoriaMethod1(){
		int a = mathService.sumatoria(5);
		Assertions.assertEquals(15,a);
	}

	@Test
	public void testSumatoriaMethod2(){
		int a = mathService.sumatoria(10);
		Assertions.assertEquals(55,a);
	}
}
