package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void replaceStringNumber() {
        String testString = "1,2";
        String[] stringArray = testString.split(",");

        assertThat(stringArray).contains(String.valueOf(1));
        assertThat(stringArray).containsExactly("1","2");
    }

    @Test
    void substringString() {
        String actual = "(1,2)";

        String substringActual = actual.substring(1,actual.length()-1);
        assertThat(substringActual).isEqualTo("1,2");
    }

    @DisplayName("문자열_parsing_Exception")
    @Test
    void stringChartAt() {
        String actual = "abc";

        assertThatThrownBy(()->{actual.charAt(4);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("range: 4");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    actual.charAt(5);
                }).withMessageMatching("String index out of range: 5");
    }
}
