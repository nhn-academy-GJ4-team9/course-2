package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex10_5 {
    private record ScoreInfo(String lastName, String firstName, int score){

    }

    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith","John",70),
            new ScoreInfo("Doe","Mary",85),
            new ScoreInfo("Page","Alice",82),
            new ScoreInfo("Cooper","Jill",97),
            new ScoreInfo("Flintstone","Fred",66),
            new ScoreInfo("Rubble","Barney",80),
            new ScoreInfo("Smith","Judy",48),
            new ScoreInfo("Dean","James",90),
            new ScoreInfo("Russ","Joe",55),
            new ScoreInfo("Wolfe","Bill",73),
            new ScoreInfo("Dart","Mary",54),
            new ScoreInfo("Rogers","Chris",78),
            new ScoreInfo("Toole","Pat",51),
            new ScoreInfo("Khan","Omar",93),
            new ScoreInfo("Smith","Ann",95)
    };

    public static void main(String[] args) {
        long count = Arrays.stream(scoreData).parallel().count();
        System.out.println("Number of students: " + count);

        double avg = Arrays.stream(scoreData).parallel().mapToInt( s -> s.score ).average().getAsDouble();
        System.out.printf("Average grade:  %1.2f%n", avg );

        long countA = Arrays.stream(scoreData).parallel().filter( s -> s.score >= 90 ).count();
        System.out.println("Number who got an A: " + countA);

        List<String> failing = Arrays.stream(scoreData)
                .filter( s -> (s.score < 70) )
                .map( s -> (s.firstName + " " + s.lastName) )
                .collect( Collectors.toList() );

        System.out.println("Failing students: ");
        failing.stream().forEach( System.out::println );

        System.out.println("Data sorted by last name:");
        Arrays.stream(scoreData).sorted( (s1,s2) -> s1.lastName.compareTo(s2.lastName) )
                .forEach( s -> System.out.printf("  %s, %s: %d%n", s.lastName, s.firstName, s.score) );

        System.out.println("Data sorted by score:");
        Arrays.stream(scoreData).sorted( (s1,s2) -> s1.score - s2.score )
                .forEach( s -> System.out.printf("  %s, %s: %d%n", s.lastName, s.firstName, s.score) );

    }
}
