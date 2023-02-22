package com.exam.shoppingcart;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import static org.mockito.ArgumentMatchers.any;
// import static org.hamcrest.CoreMatchers.is;
// import static org.mockito.ArgumentMatchers.*;
// import static org.mockito.BDDMockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
// import org.hibernate.annotations.UpdateTimestamp;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingCartControllerTests {

   
    private MockMvc mvc;

    @Mock
    private ProductServiceImpl productService;


	@InjectMocks
	private ProductController controller;

	private JacksonTester<Product> json;
	private JacksonTester<Collection<Product>> jsonList;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void contextLoads() {
	}

    @Test
	public void canSaveProduct() throws Exception {
		Product prod1 = new Product(1L,
        "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg", 
        "Ruby Slippers", "An impressive pair of slippers featuring thousands of real rubies", "long desc",
         (double) 684750000);
		when(productService.saveProduct(prod1)).thenReturn(prod1);
		mvc.perform(post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(prod1).getJson()))
				.andExpect(status().isCreated());
	}

    @Test
	public void canGetAllProducts() throws Exception {
		Product prod1 = new Product(1L,
        "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg", 
        "Ruby Slippers", "An impressive pair of slippers featuring thousands of real rubies", "long desc",
         (double) 684750000);
        
         Product prod2 = new Product(2L,
         "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg", 
         "Ruby Slippers", "An impressive pair of slippers featuring thousands of real rubies", "long desc",
          (double) 684750000);

		List<Product> allProducts = new ArrayList<Product>();
		allProducts.add(prod1);
		allProducts.add(prod2);
		when(productService.getAllProducts()).thenReturn(allProducts);
		mvc.perform(get("/api/products")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonList.write(allProducts).getJson()));
	}

    @Test
	public void canGetProductById() throws Exception {
		Product prod1 = new Product(1L,
        "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg", 
        "Ruby Slippers", "An impressive pair of slippers featuring thousands of real rubies","long desc",
         (double) 684750000);
		when(productService.getProductById(1L)).thenReturn(prod1);
		mvc.perform(get("/api/products/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(prod1).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(json.write(prod1).getJson()));

	}

    @Test
	public void canDeleteProducts() throws Exception {
		Product prod1 = new Product(1L,
        "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg", 
        "Ruby Slippers", "An impressive pair of slippers featuring thousands of real rubies","long desc",
         (double) 684750000);
		when(productService.getProductById(1L)).thenReturn(prod1);
		mvc.perform(delete("/api/products/1"))
			.andExpect(status().isNoContent());
	}



}
