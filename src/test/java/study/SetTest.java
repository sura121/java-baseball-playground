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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;
    private int number;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @DisplayName("number_size_check")
    @Test
    void hashSetSizeCheck() {
        Integer size = numbers.size();
        assertThat(size).isEqualTo(4);
    }


    @ValueSource(ints = {1,2,3})
    @ParameterizedTest
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "5:false"}, delimiter =':')
    void containsTest2(int number, boolean expect) {
        boolean result = numbers.contains(number);
        assertEquals(result, expect);
    }


}
