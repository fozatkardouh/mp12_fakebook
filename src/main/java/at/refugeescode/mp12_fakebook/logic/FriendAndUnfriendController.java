package at.refugeescode.mp12_fakebook.logic;

import at.refugeescode.mp12_fakebook.model.Friend;
import at.refugeescode.mp12_fakebook.model.Person;
import at.refugeescode.mp12_fakebook.persistent.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendAndUnfriendController {

    private final PersonRepository personRepository;

    public Boolean friendPeople(Long id1, Long id2) {
        Optional<Person> optionalPerson1 = personRepository.findById(id1);
        if (!optionalPerson1.isPresent()) {
            return false;
        }
        Optional<Person> optionalPerson2 = personRepository.findById(id2);
        if (!optionalPerson2.isPresent()) {
            return false;
        }
        Person person1 = optionalPerson1.get();
        Person person2 = optionalPerson2.get();
        person1.addFriend(getFriendFrom(person2));
        person2.addFriend(getFriendFrom(person1));
        personRepository.save(person1);
        personRepository.save(person2);
        return true;
    }

    private Friend getFriendFrom(Person person) {
        return Friend.builder()
                .id(person.getId())
                .name(person.getName())
                .build();
    }

    public Boolean unfriendPeople(Long id1, Long id2) {
        Optional<Person> optionalPerson1 = personRepository.findById(id1);
        if (!optionalPerson1.isPresent()) {
            return false;
        }
        Optional<Person> optionalPerson2 = personRepository.findById(id2);
        if (!optionalPerson2.isPresent()) {
            return false;
        }
        Person person1 = optionalPerson1.get();
        Person person2 = optionalPerson2.get();
        person1.removeFriend(getFriendFrom(person2));
        person2.removeFriend(getFriendFrom(person1));
        personRepository.save(person1);
        personRepository.save(person2);
        return true;
    }

}
