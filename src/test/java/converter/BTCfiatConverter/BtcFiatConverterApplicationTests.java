package converter.BTCfiatConverter;

import converter.BTCfiatConverter.controllers.ConverterController;
import converter.BTCfiatConverter.services.ConverterService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BtcFiatConverterApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private ConverterService converterService;

	@Before
	@Autowired
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new ConverterController(converterService)).build();
	}

	@Test
	public void testExchangeRates() throws Exception {
		this.mockMvc.perform(get("/exchange-rates")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();
	}

	@Test
	public void testBtcToRub() throws Exception {
		String res = this.mockMvc.perform(get("/btc-rub?value=1")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Assertions.assertEquals(Double.toString(converterService.btcToRub(1.0)), res);
	}

	@Test
	public void testBtcToUsd() throws Exception {
		String res = this.mockMvc.perform(get("/btc-usd?value=1")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Assertions.assertEquals(Double.toString(converterService.btcToUsd(1.0)), res);
	}

	@Test
	public void testBtcToEur() throws Exception {
		String res = this.mockMvc.perform(get("/btc-eur?value=1")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Assertions.assertEquals(Double.toString(converterService.btcToEur(1.0)), res);
	}

	@Test
	public void testBtcToCny() throws Exception {
		String res = this.mockMvc.perform(get("/btc-cny?value=1")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Assertions.assertEquals(Double.toString(converterService.btcToCny(1.0)), res);
	}
}
