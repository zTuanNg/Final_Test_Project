package service;

import model.Account;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;



public class AccountService {

    public static final DecimalFormat f1 = new DecimalFormat("#,###,###");

    private List<Account> lst = new ArrayList<>();
    {
        lst.add(new Account("NguyenTuan","123","01234567"));
        lst.add(new Account("John","123","99999999"));
    }
    public List<Account> getLst() {
        return lst;
    }
    public void setLst(List<Account> lst) {
        this.lst = lst;
    }

    // get balance
    public String getBalance(Account acc) {
        return f1.format(acc.getBalance());
    }

    // get account by STK
    public Account getAccountBySTK(String stk){
        try {
            return lst.stream().filter(a->a.getAccountNumber().equals(stk)).findAny().get();
        }catch (Exception e){
            return null;
        }
    }

    //check valid username and password
   public boolean checkValid(String username, String password){
        Account acc;
        try {
            acc = lst.stream().filter(a->a.getUsername().equals(username)
                                       && a.getPassword().equals(password)).findFirst().get();
            return true;
        }catch (Exception e){
            return false;
        }
   }

   // get account by username and password
    public Account getAccountByUsernameAndPassword(String username, String password){
        try {
            return lst.stream().filter(a->a.getUsername().equals(username)
                                    && a.getPassword().equals(password)).findFirst().get();
        }catch (Exception e){
            return null;
        }
    }


}
