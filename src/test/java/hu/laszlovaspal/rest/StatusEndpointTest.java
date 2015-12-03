package hu.laszlovaspal.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class StatusEndpointTest {

    @Mock
    private StatusEndpoint statusEndpoint;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(statusEndpoint).build();
    }

    @Test
    public void testGetApplicitionStatusPositive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/alive"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetApplicitionStatusNegative() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/alive"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testGetApplicationVersionPositive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/version"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetApplicationVersionNegative() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/version"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}