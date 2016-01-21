package com.martinrist.katas.pangram;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for "Pangram" kata from exercism.io.
 *
 * @see <a href="http://exercism.io/exercises/java/pangram/readme"/>
 */
public class PangramTest {

    @Test
    public void emptySentence() {
        assertThat(Pangrams.isPangram(""), is(false));
    }

    @Test
    public void testLowercasePangram() {
        assertThat(Pangrams.isPangram("the quick brown fox jumps over the lazy dog"),
                    is(true));
    }

    @Test
    public void missingCharacterX() {
        assertThat(Pangrams.isPangram("a quick movement of the enemy will jeopardize five gunboats"),
                    is(false));
    }

    @Test
    public void mixedCaseAndPunctuation() {
        assertThat(Pangrams.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""),
                    is(true));
    }

    @Test
    public void nonAsciiCharacters() {
        assertThat(Pangrams.isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich."),
                    is(true));
    }

}
