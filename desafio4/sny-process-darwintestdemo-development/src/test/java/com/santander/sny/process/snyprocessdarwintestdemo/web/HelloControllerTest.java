package com.santander.sny.process.snyprocessdarwintestdemo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(HelloController.class)
@WithMockUser
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCallHelloEndpoint() throws Exception {
        mockMvc.perform(get("/sny-process-darwintestdemo/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world!"));
    }
}

