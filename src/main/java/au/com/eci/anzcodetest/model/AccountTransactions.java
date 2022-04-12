package au.com.eci.anzcodetest.model;

import au.com.eci.anzcodetest.api.TransactionListItem;

public class AccountTransactions {

    private String accountName;
    private String accountType;

    private TransactionListItem transactions[];

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public TransactionListItem[] getTransactions() {
        return transactions;
    }

    public void setTransactions(TransactionListItem[] transactions) {
        this.transactions = transactions;
    }

}
