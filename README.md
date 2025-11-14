# KMP String Matching Algorithm Implementation in Java

## Project Overview

This project implements the **Knuth–Morris–Pratt (KMP) algorithm** from scratch in Java for substring search.  
The algorithm efficiently finds all occurrences of a pattern within a text, avoiding redundant comparisons by using a precomputed prefix-suffix table (LPS array).

The implementation is designed to handle strings of different lengths, from short to very long, and provides JSON-based input/output for easy testing and analysis.



## Algorithm Description

The **KMP algorithm** works in two main steps:

1. **Build the Longest Prefix Suffix (LPS) array**:
   - For each position in the pattern, LPS[i] stores the length of the longest proper prefix which is also a suffix for the substring pattern[0..i].
   - This allows the algorithm to skip unnecessary comparisons when a mismatch occurs.

2. **Search the pattern in the text**:
   - Compare the text and pattern character by character.
   - On a mismatch, use the LPS array to determine how far to shift the pattern without re-checking already matched characters.
   - Record all starting indices where the pattern matches the text.



## Implementation Details

- **KMP.java**: contains the implementation of the KMP algorithm with detailed comments explaining each step.
- **Main.java**: reads input JSON files, runs the algorithm, and outputs results in JSON format.
- **Input JSON files**: three examples of different lengths (`input_short.json`, `input_medium.json`, `input_long.json`).
- **Output JSON files**: generated after running `Main.java` (`output_short.json`, etc.).
- **Python script**: generates graphs for time and space complexity based on the output JSON.

### Code Highlights

- The `search()` method returns a list of all starting indices where the pattern matches the text.
- The `buildLPS()` method computes the LPS array for efficient pattern shifting.
- The `Main.java` file:
  - Reads JSON input (`pattern` and `text`)
  - Calls the KMP search
  - Measures execution time
  - Saves results as JSON including `matches`, `textLength`, and `timeMs`

All methods are well-commented to explain the logic and workflow.



## Testing

The algorithm was tested on three types of input:

1. **Short string**  
   - Pattern: `"aba"`  
   - Text: `"ababa"`  
   - Matches found: `[0, 2]`  
   - Execution time: `~0.019 ms`

2. **Medium-length string**  
   - Pattern: `"needle"`  
   - Text: `"finding a needle in a haystack needle appears twice"`  
   - Matches found: `[10, 31]`  
   - Execution time: `~0.0197 ms`

3. **Long string**  
   - Pattern: `"abcabc"`  
   - Text: repeated `"abcabc"` sequence (length 60)  
   - Matches found: `[0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54]`  
   - Execution time: `~0.0312 ms`

This demonstrates how the algorithm scales with input size and pattern complexity.



## Time and Space Complexity Analysis

### Time Complexity

- **Building LPS array**: `O(m)` where `m = pattern length`  
- **Searching**: `O(n)` where `n = text length`  
- **Overall**: `O(n + m)`  
  - Efficient because no character in the text is compared more than once.
  - Ideal for long texts and repetitive patterns.

### Space Complexity

- **LPS array**: `O(m)`  
- **Matches list**: `O(k)` where `k` is the number of occurrences  
- **Overall**: `O(m + k)`  
  - Minimal extra space compared to brute-force algorithms.



## JSON Input/Output Format

**Input JSON Example**:

```json
{
  "pattern": "aba",
  "text": "ababa"
}
```

## Output JSON Example

```json
{
  "pattern": "aba",
  "textLength": 5,
  "matches": [0, 2],
  "timeMs": 0.019
}
```

##Graphing Complexity

A Python script plot_complexity.py is provided to generate graphs showing:

Time complexity (execution time vs text length)

Space complexity (estimated memory usage vs text length)

This allows visualization of algorithm behavior for short, medium, and long inputs.


##Summary

Implemented KMP algorithm from scratch in Java

Tested with short, medium, and long strings

Time complexity: O(n + m), Space complexity: O(m + k)

Fully commented code with clear workflow

JSON-based input/output and Python visualization provided
