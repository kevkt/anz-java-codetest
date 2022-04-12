package au.com.eci.anzcodetest.data;

import au.com.eci.anzcodetest.api.AccountListItem;
import au.com.eci.anzcodetest.model.AccountTransactions;

import java.util.ArrayList;

/**
 * Requires an implementation that will return user accounts from the system of record.
 */
public interface IAccountsDAO {

    ArrayList<AccountListItem> getAccountList();
    AccountTransactions getAccountTransactions(String accountNumber);
}
