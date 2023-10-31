package Ex_05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**
     * 학생 수를 인쇄합니다( scoreData.length를 사용하지 않음 ).
     * 모든 학생의 평균 점수를 출력하세요.
     * A를 받은 학생의 수(90점 이상)를 출력하세요.
     * Collect() 스트림 작업을 사용하여 점수가 70점 미만인 학생의 이름이 포함된 List<String>을 만듭니다 . 이름은 이름 뒤에 성의 형식이어야 합니다.
     * 이전 작업에서 생성된 목록 의 이름을 인쇄합니다.
     * 성순으로 정렬하여 학생의 이름과 점수를 인쇄합니다.
     * 점수순으로 정렬하여 학생의 이름과 점수를 인쇄합니다.
     **/
    public static void main(String[] args) {
        System.out.println("학생수");
        Stream<ScoreInfo> stream = Arrays.stream(scoreData);
        System.out.println(stream.count());
        System.out.println("학생의 평균점수");
        stream = Arrays.stream(scoreData);
        System.out.println(stream.mapToInt(ScoreInfo -> ScoreInfo.getScore()).average().getAsDouble());
        System.out.println("90점 이상 학생의 수");
        stream = Arrays.stream(scoreData);
        System.out.println(stream.mapToInt(ScoreInfo -> ScoreInfo.getScore()).filter(score -> (90 <= score)).count());
        System.out.println("Collect() 스트림 작업을 사용하여 점수가 70점 미만인 학생의 이름이 포함된 List<String>");
        stream = Arrays.stream(scoreData);
        stream.filter(scoreInfo -> scoreInfo.getScore() < 70)
                .map(scoreInfo -> scoreInfo.getFirstName() + " " + scoreInfo.getLastName())
                .collect(Collectors.toList()).forEach(i -> System.out.println(i));
        System.out.println("성순으로 정렬하여 학생의 이름과 점수를 인쇄");
        stream = Arrays.stream(scoreData);
        stream.sorted((s1,s2) -> CharSequence.compare(s2.getLastName(), s1.getLastName())).forEach(i -> System.out.println(i.getLastName()+" " +i.getFirstName()));
        System.out.println("점수순으로 정렬하여 학생의 이름과 점수를 인쇄합니다.");
        stream = Arrays.stream(scoreData);
        stream.sorted((s1,s2) -> Integer.compare(s2.getScore(), s1.getScore())).forEach(i -> System.out.println(i.getScore()));

    }


    public static class ScoreInfo {
        private String firstName;
        private String lastName;
        private int score;

        public ScoreInfo(String firstName, String lastName, int score) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }


    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith", "John", 70),
            new ScoreInfo("Doe", "Mary", 85),
            new ScoreInfo("Page", "Alice", 82),
            new ScoreInfo("Cooper", "Jill", 97),
            new ScoreInfo("Flintstone", "Fred", 66),
            new ScoreInfo("Rubble", "Barney", 80),
            new ScoreInfo("Smith", "Judy", 48),
            new ScoreInfo("Dean", "James", 90),
            new ScoreInfo("Russ", "Joe", 55),
            new ScoreInfo("Wolfe", "Bill", 73),
            new ScoreInfo("Dart", "Mary", 54),
            new ScoreInfo("Rogers", "Chris", 78),
            new ScoreInfo("Toole", "Pat", 51),
            new ScoreInfo("Khan", "Omar", 93),
            new ScoreInfo("Smith", "Ann", 95)
    };

}
