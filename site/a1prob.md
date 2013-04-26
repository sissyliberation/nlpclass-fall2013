---
layout: default
title: Assignment 1 - Probability
---

Due: Monday, February 7, 12pm
This assignment is based on problems 1-5 of Jason Eisner's language modeling homework plus a small programming problem (problem 6). The first thing to do is to download the PDF of the homework. Many thanks to Jason E for making this and other materials for teaching NLP available!

Work through problems 1-5 and hand in your written solutions for this homework in class. Problem 6 asks you to write a small program, which you will submit on Blackboard. 

A few notes:

You will not do the entire homework -- only problems 1-5 on pages 1-8. (You'll be seeing some of the other problems later.)
The Eisner homework states you may use any programming language. For this class, you must use Python.
The Eisner homework states you should put your answers in a README file. You should not do this -- you should write down or print out your answers to 1-5 and hand in a physical copy on the due date. IMPORTANT: Be sure to write legibly so that we can read it!
If you have any questions about any of this, don't hesitate to ask.
You are welcome to consult books that cover probability theory, such as DeGroot and Schervish or the appendices of Cormen et al, as well as the slides on probability from Dickinson, Eisner and Martin. Also, usage of Wikipedia in conjunction with the course readings, notes and assignments is acceptable (especially if you learn something from it). For this assignment, it may be helpful to consult the following: Algebra of sets (especially if you're rusty on set theory) and Bayes' theorem which is not extensively discussed in Jurafsy & Martin.

There are 100 points total in this assignment. Point values for each problem/sub-problem are given below.

Problem 1: 33 points total (3 points per subproblem)

Problem 2: 15 points

a. 1
b. 1
c. 4
d. 4
e. 4
f. 1

Problem 3: 15 points

a. 1
b. 4
c. 10  (2 pts per subproblem)

Problem 4: 7 points

Problem 5: 15 points

a. 4
b. 5
c. 3
d. 3

Problem 6: 15 points
This problem is very small programming exercise intended to give you a small amount of practice counting things in text and to make sure you are comfortable running a program on the Unix command line.

First, download the text of Jane Austen's book Persuasion from Project Gutenberg. Then, use the tr command as follows in order to create word-per-line version containing only alphabetic characters:

$ cat 105.txt | tr -cs '[:alpha:]' '\n' >  105_wpl.txt
Now, write a Java or Python program that reads in 105_wpl.txt and counts bigrams and unigrams in an associative array (dictionary/hashmap) and prints out the conditional probabilities:

p(the | of)
p(the | and)
Call your program compute_bigram.py. It should take the file 105_wpl.txt as its first command-line argument, and produce the following output

$ python compute_bigram.py 105_wpl.txt
p(the|of) = 0.16878742515
p(the|and) = 0.0399002493766
We will of course test these values on another text, so you should make sure to actually compute the values and not just print them out… 

Here's a stub Python script which deals with the command line args to get you going:

#!/usr/bin/python
 
import sys
 
## Take file from stdin or as first arg on command line depending on
## how count_words.py is called.
in_file = sys.stdin
if len(sys.argv) > 1:
    in_file = file(sys.argv[1])
 
unigram_counts = {}
bigram_counts = {}
 
# Do your counting in a loop here.
 
print "p(the|of) =", # use the counts to compute the conditional probability 
print "p(the|and) =", # use the counts to compute the conditional probability 
The UT Compling Lab has a page with lots of useful python_tips that you might also find helpful.

Submit your file compute_bigram.py on Blackboard in the submission area for HW1. Remember that your solutions for Problems 1-5 must be handed in as hard copy in class.