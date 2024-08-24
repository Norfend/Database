package CP5.services;

import CP5.dao.AccountDao;
import CP5.dao.ClientDao;
import CP5.model.entities.Account;
import CP5.model.entities.Client;
import CP5.model.types.PersonId;

import java.util.List;

public class ClientServices {
    private static final AccountDao accountDao = new AccountDao();
    private static final ClientDao clientDao = new ClientDao();
    public static void addClient(String inputName, String inputSecondName, String inputPassword,
                                 String phoneNumber) {
        Client newClient = new Client();
        PersonId newPersonId = new PersonId();
        newPersonId.setFirstName(inputName);
        newPersonId.setSecondName(inputSecondName);
        newClient.setId(newPersonId);
        newClient.setLoyaltyPoints(0);
        newClient.setPhoneNumber(phoneNumber);
        Account newAccount = new Account();
        newAccount.setLogin(inputName);
        newAccount.setPassword(inputPassword);
        newAccount.setPerson(newClient);
        newClient.setAccountsLogin(newAccount);
        accountDao.create(newAccount);
    }

    public static void readClient(String inputName, String inputSecondName) {
        List<Client> clients = clientDao.findByName(inputName, inputSecondName);
        for (Client person: clients) {
            System.out.println(person.getId().getFirstName() + " " +
                    person.getId().getSecondName() + " " + person.getPhoneNumber());
        }
    }

    public static void deleteClient(String inputLogin) {
        clientDao.delete(clientDao.findByAccountsLogin(inputLogin));
    }

    public static void updateClient(String accountName, String newPhoneNumber) {
        Client updatedClient = clientDao.findByAccountsLogin(accountName);
        updatedClient.setPhoneNumber(newPhoneNumber);
        clientDao.update(updatedClient);
    }
}
