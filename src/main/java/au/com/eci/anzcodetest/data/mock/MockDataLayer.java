package au.com.eci.anzcodetest.data.mock;

import au.com.eci.anzcodetest.api.AccountListItem;
import au.com.eci.anzcodetest.api.AccountTransactionsResponse;
import au.com.eci.anzcodetest.data.IAccountsDAO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Mock implementation for demonstration purposes.
 */
@Service
public class MockDataLayer implements IAccountsDAO {

    @Value("classpath:data/accountList.json")
    private Resource accountListFile;

    @Value("classpath:data/accountTransactions.json")
    private Resource accountTransactionsFile;

    @Override
    public ArrayList<AccountListItem> getAccountList() {
        return demoAppGetAccountList();
    }

    @Override
    public AccountTransactionsResponse getAccountTransactions(String accountNumber) {
        return demoAppGetTransactionsForAccount(accountNumber);
    }

    private ArrayList<AccountListItem> demoAppGetAccountList() {
        ArrayList<AccountListItem> accountList = new ArrayList<>();
        AccountListItem[] list = demoAppLoadDataFromFile(accountListFile, AccountListItem[].class);
        if (list != null)
            Collections.addAll(accountList, list);

        return accountList;
    }

    private AccountTransactionsResponse demoAppGetTransactionsForAccount(String accountNumber) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
            JsonNode rootNode = mapper.readTree(accountTransactionsFile.getFile());
            JsonNode accountTransactionsNode = rootNode.get(accountNumber);

            return accountTransactionsNode == null
                    ? null : mapper.readValue(accountTransactionsNode.toString(), AccountTransactionsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static <T> T demoAppLoadDataFromFile(Resource resource, Class<T> classType) {
        T t = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            File file = resource.getFile();
            t = mapper.readValue(file, classType);
        } catch (IOException ioe) {
            //
            System.out.println("Exception");
            ioe.printStackTrace();
        }

        return t;
    }

}
