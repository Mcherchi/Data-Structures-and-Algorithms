# Algorithm Time-Complexity Analysis

## Goal

The goal of this document is to provide guidelines for analyzing the runtime of algorithms as the number of elements increases.

## 5 Rules

1. Analyze the worst-case performance of the algorithm, denoted as Big O.
2. Add steps in order (+); multiply nested steps (\*).
3. Different inputs should have different variables, e.g., O(a+b).
4. Remove constants.
5. Drop non-dominant terms.

## 3 Types of Time Complexity

1. **Big O – Worst Case**

   - **Ideal:**
     - O(1) – Constant
     - O(log n) – Logarithmic
     - O(n) – Linear
   - **Acceptable:**
     - O(n \* log n) – Log Linear
   - **Avoid:**
     - O(n^2) – Quadratic
     - O(2^n) – Exponential
     - O(n!) – Factorial

2. **Big Θ – Average/Tight Case**

3. **Big Ω – Best Case**

## Resources

- [Big-O Algorithm Complexity Cheat Sheet (Know Thy Complexities!)](https://www.bigocheatsheet.com/) by @ericdrowell
