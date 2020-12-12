import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;



public class ArrayWorkTest {
    @ParameterizedTest
    @MethodSource("actualAndExpectedResultsProvider")
    void shouldReturnArrayAfterSearch(int[] parameters, int[] expected) {
        Assertions.assertArrayEquals(expected, ArraysWork.findElementsAfterDigit(parameters, 4));
    }

    private java.util.stream.Stream<Arguments> actualAndExpectedResultsProvider() {
        return java.util.stream.Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[] {5}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4, 5, 8, 5, 1}, new int[] {5, 8, 5, 1}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4}, new int[] {})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("wrongParametersProvider")
    void shouldThrowRuntimeExcetionWhenValueNotFound(int[] parameters) {
        Assertions.assertNotNull(
                Assertions.assertThrows(
                        RuntimeException.class,
                        () -> ArraysWork.findElementsAfterDigit(parameters, 4)
                )
        );
    }

    private java.util.stream.Stream<int[]> wrongParametersProvider() {
        return java.util.stream.Stream.of(new int[]{1, 2, 3, 5});
    }
}
