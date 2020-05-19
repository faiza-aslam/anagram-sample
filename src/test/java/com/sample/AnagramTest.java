package com.sample;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnagramTest {

    private Anagram anagramUnderTest;

    @Before
    public void setUp() {
        anagramUnderTest = new Anagram();
    }

    @Test
    public void testGetAnagramList1() {
        // Setup
        final List<String> inputList = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        final List<List<String>> expectedResult = Arrays.asList(Arrays.asList("eat", "tea", "ate"), Arrays.asList("tan", "nat"), Collections.singletonList("bat"));

        // Run the test
        final List<List<String>> result = anagramUnderTest.getAnagrams(inputList);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAnagramList2() {
        // Setup
        final List<String> inputList = new ArrayList<>();
        final List<List<String>> expectedResult = Collections.emptyList();

        // Run the test
        final List<List<String>> result = anagramUnderTest.getAnagrams(inputList);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAnagramList3() {
        // Setup
        final List<String> inputList = Arrays.asList("eat", "tea");
        final List<List<String>> expectedResult = Collections.singletonList(Arrays.asList("eat", "tea"));

        // Run the test
        final List<List<String>> result = anagramUnderTest.getAnagrams(inputList);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAnagramList4() {
        // Setup
        final List<String> inputList = Collections.singletonList("eat");
        final List<List<String>> expectedResult = Collections.singletonList(Collections.singletonList("eat"));

        // Run the test
        final List<List<String>> result = anagramUnderTest.getAnagrams(inputList);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAnagramList5() {
        // Setup
        final List<String> inputList = Arrays.asList("eat", "bat", "meat");
        final List<List<String>> expectedResult = Arrays.asList(Collections.singletonList("eat"), Collections.singletonList("bat"), Collections.singletonList("meat"));

        // Run the test
        final List<List<String>> result = anagramUnderTest.getAnagrams(inputList);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
