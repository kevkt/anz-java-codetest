package au.com.eci.anzcodetest.controller;

import au.com.eci.anzcodetest.api.AccountListResponse;
import au.com.eci.anzcodetest.api.AccountTransactionsResponse;
import au.com.eci.anzcodetest.service.IAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Define the Restful APIs endpoints to be handled by the View Accounts service.
 */
@RestController
public class ViewAccountsController {

    @Autowired
    private IAccountServices accountServices;

    /**
     * API endpoint to retrieve a list of user accounts.
     *
     * @return List of user accounts.
     */
    @GetMapping(value = "/v1/accounts/list",
            produces = APPLICATION_JSON_VALUE)
    public AccountListResponse retrieveAccountList() {
        AccountListResponse resp = accountServices.retrieveAccountList();
        return resp;
    }

    /**
     * API endpoint to retrieve a list of transactions for the selected account.
     *
     * @param accountNumber User account from the request.
     * @return Transactions for the user selected account.
     */
    @GetMapping(value = "/v1/accounts/{accountNumber}/transactions/list",
            produces = APPLICATION_JSON_VALUE)
    public AccountTransactionsResponse retrieveAccountTransactions(@PathVariable(value = "accountNumber") String accountNumber) {
        return accountServices.retrieveAccountTransactions(accountNumber);
    }

}
