package com.assignment.currency_converter;

import com.assignment.currency_converter.controller.ConversionController;
import com.assignment.currency_converter.service.calculation.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class CurrencyConverterApplicationTests {

    @Autowired
    private ConversionController controller;

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(calculationService).isNotNull();
    }

    /**
     * Test calculation API response with csrf
     */
    @Test
    public void calculateValueWithCSRF() throws Exception {
        mockMvc
                .perform(
                        post("/calculate-value")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("sourceCurrency", "USD")
                                .param("targetCurrency", "RUB")
                                .param("monetaryValue", "100")
                                .with(user("admin").password("pass"))
                                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("resultValue", notNullValue()));
    }

    /**
     * Test calculation API response without csrf
     */
    @Test
    public void calculateValueWithoutCSRF() throws Exception {
        mockMvc
                .perform(
                        post("/calculate-value")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("sourceCurrency", "USD")
                                .param("targetCurrency", "RUB")
                                .param("monetaryValue", "100")
                                .with(user("admin").password("pass")))
                .andExpect(status().isForbidden());
    }

    /**
     * Test calculation correctness
     */
    @Test
    public void calculationCorrectness() {
        Map<String, Number> rates = new HashMap<>();
        rates.put("USD", 1.088354);
        rates.put("RUB", 74.73534);
        String result =
                calculationService
                        .getFormattedResultValue(rates, "USD", "RUB", 100.0)
                        .replaceAll("\u00a0", "")
                        .replaceAll("\\s+", "");
        assertThat(result).isEqualTo("6866,82₽");
    }
}
