package au.com.eci.anzcodetest.controller;

import au.com.eci.anzcodetest.model.UserAccountNotFoundException;
import au.com.eci.anzcodetest.service.IAccountServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Some initial tests for the API endpoints.
 */
@AutoConfigureMockMvc
@WebMvcTest
public class ViewAccountsControllerTest {

    @MockBean
    private IAccountServices accountServices;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAccountListSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/accounts/list"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAccountTransactionSuccess() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/accounts/{accountNumber}/transactions/list", "1234"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUserAccountNotFound() throws Exception {
        Mockito.when(accountServices.retrieveAccountTransactions("1234")).thenThrow(new UserAccountNotFoundException("account 1234 not found"));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/accounts/{accountNumber}/transactions/list", "1234"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testInvalidEndpoint() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/accounts//transaction"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}
