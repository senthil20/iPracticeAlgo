package ds.MiscJava;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Friend {
    private Collection<Friend> friends;
    private String email;
    private Map<Friend, Boolean> visited = new HashMap<>();


    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        if (this.friends.contains(friend)) return true;
        return canBeConnectedRecursive(friend, friend, friend.friends);
    }

    public boolean canBeConnectedRecursive(Friend friend, Friend next, Collection friendList) {
         if (friendList.contains(friend)) return true;
         visited.put(next, true);
         Iterator it = friendList.iterator();
         while (it.hasNext()) {
             next = (Friend) it.next();
             if (visited.containsKey(next)) continue;
             return canBeConnectedRecursive(friend, next, next.friends);
         }
         return false;
     }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}
