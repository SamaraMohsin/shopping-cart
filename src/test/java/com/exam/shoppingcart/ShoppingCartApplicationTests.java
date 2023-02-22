package com.exam.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingCartApplicationTests {

	@Mock
	private ProductRepository ProductRepo;
	
	@InjectMocks
	private ProductServiceImpl ProductServiceImpl;

	@Test
	void contextLoads() {
	}

	@Test
	void getAndSetProductID(){
		Product cut = new Product();
		Long prodId = 1L;
		cut.setId(prodId);
		assertEquals(prodId, cut.getId());
	}

	@Test
	void getAndSetProductImg(){
		Product cut = new Product();
		String prodImg = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		cut.setProdImg(prodImg);
		assertEquals(prodImg, cut.getProdImg());
	}

	@Test
	void getAndSetProductName(){
		Product cut = new Product();
		String prodName = "Ruby Slippers";
		cut.setProdName(prodName);
		assertEquals(prodName, cut.getProdName());
	}

	@Test
	void getAndSetProductDescription(){
		Product cut = new Product();
		String prodDesc = "An impressive pair of slippers featuring thousands of real rubies";
		cut.setShortDescription(prodDesc);
		assertEquals(prodDesc, cut.getShortDescription());
	}

	@Test
	void getAndSetProductPrice(){
		Product cut = new Product();
		Double prodPrice = (double) 684750000;
		cut.setProdPrice(prodPrice);
		assertEquals(prodPrice, cut.getProdPrice());
	}

	@Test
	void getAndSetProductQuantity(){
		Product cut = new Product();
		Integer prodQuantity = 2;
		cut.setProdQuantity(prodQuantity);
		assertEquals(prodQuantity, cut.getProdQuantity());
	}


	
	
	

}
