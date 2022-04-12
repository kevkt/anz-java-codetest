package au.com.eci.anzcodetest.api;

import au.com.eci.anzcodetest.model.AccountTransactions;

/**
 * Top level object defining the response for the account transaction API.
 */
public class AccountTransactionsResponse extends AccountTransactions {

    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
