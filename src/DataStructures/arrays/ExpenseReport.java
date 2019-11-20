package DataStructures.arrays;

import java.util.*;

public class ExpenseReport {
    class User {
        String userName;
        Set<String> expenseType = new HashSet<>();
        int amountSpent = 0;

        User(String userName) {
            this.userName = userName;
        }
        User(String userName, String expenseType, Integer amountSpent) {
            this.userName = userName;
            this.expenseType.add(expenseType);
            this.amountSpent = amountSpent;
        }
    }
    class Expense {
        Map<String, User> userMap = new HashMap<>();

        Expense () {

        }
        Expense(String userName, Integer amount, String expenseType, List<String> otherUsersList) {
            creditForUser(userName, expenseType, amount);
            debitForUser(userName, amount, otherUsersList);
        }

        public void creditForUser(String userName, String expenseType, Integer amountSpent) {
            if (userMap.containsKey(userName)) {
                userMap.get(userName).expenseType.add(expenseType);
                userMap.get(userName).amountSpent += amountSpent;
            }
            else {
                User user = new User(userName, expenseType, amountSpent);
                userMap.put(userName, user);
            }
        }

        public void debitForUser(String user, Integer amountSpent, List<String> users) {
            int individualExpense  = amountSpent / users.size();
            for (String u : users) {
                if (!userMap.containsKey(u)) {
                    userMap.put(u, new User(u));
                }
                userMap.get(u).amountSpent -= individualExpense;
            }
        }

        public List<String> getIndividulExpense() {
            List<String> result = new ArrayList<>();
            List<User> users = new ArrayList<>(userMap.values());

            for (User user : users) {
                Integer bal = user.amountSpent;
                if (bal < 0) {
                    result.add(user.userName + " has to give " + -bal);
                }
                else {
                    result.add(user.userName + " gets " + bal);
                }
            }
            return result;
        }
    }

    public void buildUser(String userName, Integer amount, String expenseType, String listOfUsers) {
        List<String> otherUsersList = new ArrayList<>();
        String[] otherUsers = listOfUsers.split(",");
        for (String val : otherUsers) {
            otherUsersList.add(val);
        }
        new Expense(userName, amount, expenseType, otherUsersList);
    }

    public static void main(String a[]) {
        ExpenseReport exp = new ExpenseReport();
        /*Scanner sc = new Scanner(System.in);
        //total lines
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String user = sc.next();
            int amount = sc.nextInt();
            String expenseType = sc.next();
            String to = sc.next();
            exp.buildUser(user, amount, expenseType, to);
            sc.nextLine();
        }*/
        exp.buildUser("A", 100, "Snacks", "A,B,C,D");
        exp.buildUser("B", 500, "Taxi", "C,D");
        exp.buildUser("D", 300, "Bus", "A,B");

        List<String> report = exp.new Expense().getIndividulExpense();
        for (String val : report) {
            System.out.println(val);
        }
    }
}
