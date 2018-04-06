package at.refugeescode.mp12_fakebook.endpoint;

import at.refugeescode.mp12_fakebook.logic.FriendAndUnfriendController;
import at.refugeescode.mp12_fakebook.model.Friend;
import at.refugeescode.mp12_fakebook.model.Person;
import at.refugeescode.mp12_fakebook.persistent.FriendRepository;
import at.refugeescode.mp12_fakebook.persistent.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonEndpoint {

    private final PersonRepository personRepository;
    private final FriendRepository friendRepository;
    private final FriendAndUnfriendController friendAndUnfriendController;

    @PostMapping
    public Person addPerson(@RequestBody Friend friend) {
        Friend newfriend = friendRepository.save(friend);
        Person person = Person.builder()
                .id(newfriend.getId())
                .name(newfriend.getName())
                .build();
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @DeleteMapping
    public Boolean deleteAll() {
        personRepository.deleteAll();
        friendRepository.deleteAll();
        return true;
    }

    @GetMapping("/{id1}/friend/{id2}")
    public Boolean friendPerson(@PathVariable Long id1, @PathVariable Long id2) {
        return friendAndUnfriendController.friendPeople(id1, id2);
    }

    @GetMapping("/{id1}/unfriend/{id2}")
    public Boolean unfriendPerson(@PathVariable Long id1, @PathVariable Long id2) {
        return friendAndUnfriendController.unfriendPeople(id1, id2);
    }

}
