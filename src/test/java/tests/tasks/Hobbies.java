package tests.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hobbies {
    private final HashMap<String, String[]> hobbies = new HashMap<>();

    public void add(String hobbyist, String ... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyists(String hobby) {
        return this.hobbies.entrySet()
                .stream()
                .filter(i -> Arrays.stream(i.getValue()).anyMatch(j->j.equalsIgnoreCase(hobby)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("Steve", "Fashion", "Piano", "Reading");
        hobbies.add("Patty", "Drama", "Magic", "Pets");
        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");

        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Pets").toArray()));
    }
}
