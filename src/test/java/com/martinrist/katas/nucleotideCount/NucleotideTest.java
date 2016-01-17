package com.martinrist.katas.nucleotideCount;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Test class for "Nucleotide Count" kata from exercism.io.
 *
 * @see <a href="http://exercism.io/exercises/java/nucleotide-count/readme"/>
 */
public class NucleotideTest {

    @Test
    public void testEmptyDnaStringHasNoAdenosine() {
        DNA dna = new DNA("");
        assertThat(dna.count('A'), is(0));
    }

    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        DNA dna = new DNA("");

        validateNucleotideCounts(dna.nucleotideCounts(), 0, 0, 0, 0);
    }

    @Test
    public void testRepetitiveCytidineGetsCounted() {
        DNA dna = new DNA("CCCCC");
        assertThat(dna.count('C'), is(5));
    }

    @Test
    public void testRepetitiveSequenceWithOnlyGuanosine() {
        DNA dna = new DNA("GGGGGGGG");

        validateNucleotideCounts(dna.nucleotideCounts(), 0, 0, 8, 0);
    }

    @Test
    public void testCountsOnlyThymidine() {
        DNA dna = new DNA("GGGGGTAACCCGG");
        assertThat(dna.count('T'), is(1));
    }

    @Test
    public void testCountsANucleotideOnlyOnce() {
        DNA dna = new DNA("CGATTGGG");
        dna.count('T');
        assertThat(dna.count('T'), is(2));
    }

    @Test
    public void testDnaCountsDoNotChangeAfterCountingAdenosine() {
        DNA dna = new DNA("GATTACA");
        dna.count('A');

        validateNucleotideCounts(dna.nucleotideCounts(), 3, 1, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidatesNucleotides() {
        DNA dna = new DNA("GACT");
        dna.count('X');
    }

    @Test
    public void testCountsAllNucleotides() {
        String s = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        DNA dna = new DNA(s);

        validateNucleotideCounts(dna.nucleotideCounts(), 20, 12, 17, 21);
    }

    private void validateNucleotideCounts(Map<Character, Integer> counts, int numAs, int numCs, int numGs, int numTs) {
        assertThat(counts.entrySet(), hasSize(4));
        assertThat(counts, hasEntry('A', numAs));
        assertThat(counts, hasEntry('C', numCs));
        assertThat(counts, hasEntry('G', numGs));
        assertThat(counts, hasEntry('T', numTs));
    }
}