package com.yebgi83.baseball;

import com.yebgi83.baseball.model.ThreeDigits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class AnswerCreatorTest {
    @Test
    @DisplayName("정답을 구성하는 3자리 숫자는 중복이 아니어야 한다.")
    void digitsOfAnswerShouldBeUniqueDigit() {
        ThreeDigits answer = AnswerCreator.createAnswer();

        if (!digitsOfAnswerShouldBeUniqueDigit(answer)) {
            fail();
        }
    }

    @Test
    @DisplayName("정답은 생성할 때마다 다른 숫자가 나와야 한다.")
    void answerShouldBeCreatedDifferentlyByEachTime() {
        int times = 10;

        if (!answerShouldBeCreatedDifferentlyByEachTime(times)) {
            fail();
        }
    }

    boolean digitsOfAnswerShouldBeUniqueDigit(ThreeDigits answer) {
        Set<Integer> foundDigits = new HashSet<>();

        for (int index = 0; index < 3; index++) {
            Integer digit = answer.getDigitAt(index);

            if (foundDigits.contains(digit)) {
                return false;
            }

            foundDigits.add(digit);
        }

        return true;
    }

    boolean answerShouldBeCreatedDifferentlyByEachTime(int times) {
        ThreeDigits lastAnswer = null;

        for (int trial = 1; trial <= times; trial++) {
            ThreeDigits answer = AnswerCreator.createAnswer();

            if (answer.equals(lastAnswer)) {
                return false;
            }

            lastAnswer = answer;
        }

        return true;
    }
}