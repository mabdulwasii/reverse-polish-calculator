package com.test.rpn.reversepolishcalculator.adapter.controller;

import com.test.rpn.reversepolishcalculator.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static com.test.rpn.reversepolishcalculator.TestConstants.VALID_REQUEST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationTest
@AutoConfigureMockMvc
class RpnControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loadIndexPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("response"))
                .andExpect(model().attributeExists("input"));
    }

    @Test
    void calculateValidNotation() throws Exception {
        this.mockMvc.perform(post("/")
                        .param("value", VALID_REQUEST))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("response"))
                .andExpect(model().attributeExists("input"));
    }

}