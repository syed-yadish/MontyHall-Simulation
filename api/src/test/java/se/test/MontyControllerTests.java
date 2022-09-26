package se.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import se.test.service.MontyService;
import se.test.controller.MontyController;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MontyController.class)
public class MontyControllerTests {
  @MockBean
  private MontyService service;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void whenValidInput_thenReturns201() throws Exception {
    MontyService testService = new MontyService();
    
     mockMvc.perform(post("/start")
          .contentType("application/json")
          .content(objectMapper.writeValueAsString(testService)))
          .andExpect(status().isCreated());
  }

  @Test
  public void shouldReturnOK() throws Exception {
    this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk());
  }
  
}
