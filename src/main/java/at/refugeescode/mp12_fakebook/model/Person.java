package at.refugeescode.mp12_fakebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private Long id;
    private String name;
    @OneToMany
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Friend> friends;

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public void removeFriend(Friend friend) {
        friends.remove(friend);
    }

}


