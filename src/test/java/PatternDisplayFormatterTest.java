import component.PatternDisplayFormatter;
import model.PatternResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternDisplayFormatterTest {
    @Test
    @DisplayName("1개의 스트라이크가 있으면, '1 스트라이크' 리턴")
    void formatOneStrike() {
        PatternResult patternResult = new PatternResult(1, 0);
        assertEquals(PatternDisplayFormatter.format(patternResult), "1 스트라이크");
    }

    @Test
    @DisplayName("2개의 스트라이크가 있으면, '2 스트라이크' 리턴")
    void formatTwoStrikes() {
        PatternResult patternResult = new PatternResult(2, 0);
        assertEquals(PatternDisplayFormatter.format(patternResult), "2 스트라이크");
    }

    @Test
    @DisplayName("3개의 스트라이크가 있으면, '3 스트라이크' 리턴")
    void formatThreeStrikes() {
        PatternResult patternResult = new PatternResult(3, 0);
        assertEquals(PatternDisplayFormatter.format(patternResult), "3 스트라이크");
    }

    @Test
    @DisplayName("1개의 볼이 있으면, '1 볼' 리턴")
    void formatOneBall() {
        PatternResult patternResult = new PatternResult(0, 1);
        assertEquals(PatternDisplayFormatter.format(patternResult), "1 볼");
    }

    @Test
    @DisplayName("2개의 볼이 있으면, '2 볼' 리턴")
    void formatTwoBalls() {
        PatternResult patternResult = new PatternResult(0, 2);
        assertEquals(PatternDisplayFormatter.format(patternResult), "2 볼");
    }

    @Test
    @DisplayName("3개의 볼이 있으면, '3 볼' 리턴")
    void formatThreeBalls() {
        PatternResult patternResult = new PatternResult(0, 3);
        assertEquals(PatternDisplayFormatter.format(patternResult), "3 볼");
    }

    @Test
    @DisplayName("1개의 스트라이크 및 2개의 볼이 있으면, '2 스트라이크, 1 볼' 리턴")
    void formatTwoStrikesAndOneBall() {
        PatternResult patternResult = new PatternResult(2, 1);
        assertEquals(PatternDisplayFormatter.format(patternResult), "2 스트라이크, 1 볼");
    }

    @Test
    @DisplayName("스트라이크 또는 볼이 전혀 없으면, '낫싱' 리턴")
    void formatNoStrikeAndBall() {
        PatternResult patternResult = new PatternResult(0, 0);
        assertEquals(PatternDisplayFormatter.format(patternResult), "낫싱");
    }
}
