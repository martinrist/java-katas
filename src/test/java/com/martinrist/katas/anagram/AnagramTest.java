package com.martinrist.katas.anagram;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test class for "Anagram" kata from exercism.io.
 *
 * @see <a href="http://exercism.io/exercises/java/anagram/readme"/>
 */
public class AnagramTest {

    @Test
    public void testNoMatches() {
        Anagram detector = new Anagram("diaper");
        assertThat(detector.match(Arrays.asList("hello", "world", "zombies", "pants")), empty());
    }

    @Test
    public void testSimpleAnagram() {
        Anagram detector = new Anagram("ant");
        List<String> anagram = detector.match(Arrays.asList("tan", "stand", "at"));
        assertThat(anagram, contains("tan"));
    }

    @Test
    public void testDetectMultipleAnagrams() {
        Anagram detector = new Anagram("master");
        List<String> anagrams = detector.match(Arrays.asList("stream", "pigeon", "maters"));
        assertThat(anagrams, contains("maters", "stream"));
    }

    @Test
    public void testDoesNotConfuseDifferentDuplicates() {
        Anagram detector = new Anagram("galea");
        List<String> anagrams = detector.match(Arrays.asList("eagle"));
        assertThat(anagrams, empty());
    }

    @Test
    public void testIdenticalWordIsNotAnagram() {
        Anagram detector = new Anagram("corn");
        List<String> anagrams = detector.match(Arrays.asList("corn", "dark", "Corn", "rank", "CORN", "cron", "park"));
        assertThat(anagrams, contains("cron"));
    }

    @Test
    public void testEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");
        assertThat(detector.match(Arrays.asList("last")), empty());
    }

    @Test
    public void testEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");
        assertThat(detector.match(Arrays.asList("dog", "goody")), empty());
    }

    @Test
    public void testDetectAnagrams() {
        Anagram detector = new Anagram("listen");
        List<String> anagrams = detector.match(Arrays.asList("enlists", "google", "inlets", "banana"));
        assertThat(anagrams, contains("inlets"));
    }

    @Test
    public void testMultipleAnagrams() {
        Anagram detector = new Anagram("allergy");
        List<String> anagrams = detector.match(Arrays.asList("gallery", "ballerina", "regally", "clergy", "largely", "leading"));
        assertThat(anagrams, contains("gallery", "largely", "regally"));
    }

    @Test
    public void testAnagramsAreCaseInsensitive() {
        Anagram detector = new Anagram("Orchestra");
        List<String> anagrams = detector.match(Arrays.asList("cashregister", "Carthorse", "radishes"));
        assertThat(anagrams, contains("Carthorse"));
    }
}
