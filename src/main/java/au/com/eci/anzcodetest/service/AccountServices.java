package au.com.eci.anzcodetest.service;


import au.com.eci.anzcodetest.api.AccountListItem;
import au.com.eci.anzcodetest.api.AccountListResponse;
import au.com.eci.anzcodetest.api.AccountTransactionsResponse;
import au.com.eci.anzcodetest.model.AccountTransactions;
import au.com.eci.anzcodetest.data.IAccountsDAO;
import au.com.eci.anzcodetest.model.UserAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountServices implements IAccountServices {

    static final String USER_ACCOUNT_NOT_FOUND_MESSAGE = "User account %s not found";

    @Autowired
    private IAccountsDAO accountsDao;

    /**
     * Retrieve a list of user accounts and prepare the API response.
     *
     * TODO: Use user authentication to identify the logged in user and retrieve
     *       list of accounts for that user.
     *
     * @return List of accounts for the logged in user.
     */
    public AccountListResponse retrieveAccountList() {
        AccountListResponse accountList = new AccountListResponse();
        ArrayList<AccountListItem> accounts = accountsDao.getAccountList();
        accountList.setAccountListItems(accounts);

        return accountList;
    }

    /**
     *
     * TODO: Use user authentication to identify the logged in user to ensure
     *       the user is permitted to access the requested account.
     *
     * @param accountNumber Reference to the requested account details
     * @return List of transactions for the requested account.
     */
    public AccountTransactionsResponse retrieveAccountTransactions(String accountNumber) {

        AccountTransactions account = accountsDao.getAccountTransactions(accountNumber);

        if (account == null) {
            throw new UserAccountNotFoundException(String.format(USER_ACCOUNT_NOT_FOUND_MESSAGE, accountNumber));
        }

        AccountTransactionsResponse response = new AccountTransactionsResponse();
        response.setAccountNumber(accountNumber);
        response.setAccountName(account.getAccountName());
        response.setAccountType(account.getAccountType());
        response.setTransactions(account.getTransactions());

        return response;
    }

}
