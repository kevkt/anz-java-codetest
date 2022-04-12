package au.com.eci.anzcodetest.api;

import java.util.ArrayList;

/**
 * Top level object defining the response for the account list API.
 */
public class AccountListResponse {

    private ArrayList<AccountListItem> accountListItems;

    public ArrayList<AccountListItem> getAccountListItems() {
        return accountListItems;
    }

    public void setAccountListItems(ArrayList<AccountListItem> accountListItems) {
        this.accountListItems = accountListItems;
    }
}
