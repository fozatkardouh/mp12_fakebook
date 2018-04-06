package at.refugeescode.mp12_fakebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private Long id;
    private String name;
    @OneToMany(targetEntity = Friend.class)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Friend> friends;

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public void removeFriend(Friend friend) {
        friends.remove(friend);
    }

}


