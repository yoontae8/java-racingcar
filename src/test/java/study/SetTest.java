package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set의 크기가 반환된다.")
    @Test
    void checkSize() {
        // Act
        int result = numbers.size();

        // Assert
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("set의 1, 2, 3 포함 여부를 확인하면 true가 반환된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int source) {
        // Act
        boolean result = numbers.contains(source);

        // Assert
        assertThat(result).isTrue();
    }

    @DisplayName("set의 1, 2, 3, 4, 5의 포함 여부를 확인하면 true, true, true, false, false가 반환된다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsWithDifferentResultPair(int source, boolean expected) {
        // Act
        boolean result = numbers.contains(source);

        // Assert
        assertThat(result).isEqualTo(expected);
    }
}
