package com.martinrist.katas.wordCount;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test class for "Word Count" kata from exercism.io.
 *
 * @see <a href="http://exercism.io/exercises/java/word-count/readme"/>
 */
public class WordCountTest {

    private final WordCount wordCount = new WordCount();

    @Test(expected = IllegalArgumentException.class)
    public void nullPhrase() {
        wordCount.phrase(null);
    }

    @Test
    public void emptyPhrase() {
        assertThat(wordCount.phrase(""), equalTo(Collections.EMPTY_MAP));
    }

    @Test
    public void phraseWithOnlySpaces() {
        assertThat(wordCount.phrase("    "), equalTo(Collections.EMPTY_MAP));
    }

    @Test
    public void phraseWithOnlyPunctuation() {
        assertThat(wordCount.phrase("!@£$%^"), equalTo(Collections.EMPTY_MAP));
    }

    @Test
    public void countOneWord() {
        final Map<String, Integer> expectedWordCount = ImmutableMap.of("word", 1);
        final Map<String, Integer> actualWordCount = wordCount.phrase("word");
        assertThat(actualWordCount, equalTo(expectedWordCount));
    }

    @Test
    public void countOneOfEach() {
        final Map<String, Integer> expectedWordCount =
                ImmutableMap.of("one", 1, "of", 1, "each", 1);
        final Map<String, Integer> actualWordCount = wordCount.phrase("one of each");
        assertThat(expectedWordCount, equalTo(actualWordCount));
    }

    @Test
    public void countMultipleOccurences() {
        final Map<String, Integer> expectedWordCount =
                ImmutableMap.of("one", 1, "fish", 4, "two", 1, "red", 1, "blue", 1);

        final Map<String, Integer> actualWordCount = wordCount.phrase("one fish two fish red fish blue fish");
        assertThat(expectedWordCount, equalTo(actualWordCount));
    }

    @Test
    public void ignorePunctuation() {
        final Map<String, Integer> expectedWordCount =
                ImmutableMap.of("car", 1, "carpet", 1, "as", 1, "java", 1, "javascript", 1);
        final Map<String, Integer> actualWordCount = wordCount.phrase("car : carpet as java : javascript!!&@$%^&");
        assertThat(expectedWordCount, equalTo(actualWordCount));

    }

    @Test
    public void includeNumbers() {
        final Map<String, Integer> expectedWordCount =
                ImmutableMap.of("testing", 2, "1", 1, "2", 1);
        final Map<String, Integer> actualWordCount = wordCount.phrase("testing, 1, 2 testing");
        assertThat(expectedWordCount, equalTo(actualWordCount));
    }

    @Test
    public void normalizeCase() {
        final Map<String, Integer> expectedWordCount = ImmutableMap.of("go", 3);
        final Map<String, Integer> actualWordCount = wordCount.phrase("go Go GO");
        assertThat(expectedWordCount, equalTo(actualWordCount));
    }

}
