package au.com.eci.anzcodetest.service;

import au.com.eci.anzcodetest.api.AccountListResponse;
import au.com.eci.anzcodetest.api.AccountTransactionsResponse;
import au.com.eci.anzcodetest.model.UserAccountNotFoundException;

public interface IAccountServices {

    AccountListResponse retrieveAccountList();
    AccountTransactionsResponse retrieveAccountTransactions(String accountNumber) throws UserAccountNotFoundException;
}
