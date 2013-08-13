---
layout: default
title: Assignment 0 - Programming in Scala
---

**Due: Thursday, September 5, 2pm**

This course will require you to complete several non-trivial programming assignments.  As such, to be successful in this class you must be comfortable programming.  The primary purpose of this assignment is for you to ensure that you have at least a minimum level programming competence.  

**All of the programming assignments for the rest of the course will be more difficult than this one.  If you find this assignment excessively difficult, then this course is probably not for you.**


## Overview

In this assignment, you will write code for reading texts from file and calculating basic statistics about that data.  This code will be used in subsequent programming assignments since all future assignments will require working with texts.

In the root of your repository, create a file called `Assignment0_README.txt` that contains:

* A short overview of what you've done
* A list of files relevant to this assignment
* Any commands needed to demonstrate


## Part 1: Getting set up

Follow the instructions on the [Scala Environment Setup]({{ page.root }}scala/setup.html) and [Assignment Requirements]({{ page.root }}assignments.html) pages.  At a minimum, you'll need to:

* Download and install Scala
* Download and install SBT
* Create a Github Account and register as a student
* Fork the class repository
* Create an Scala project with SBT


## Part 2: Reading from files

Download [Alice's Adventures in Wonderland](http://www.gutenberg.org/cache/epub/11/pg11.txt) from Project Gutenberg.

Write an application that does the following:

* Takes a file path of as a command-line argument
* Removes all punctuation and numbers and lowercases all words
* Prints the total number of words in the book
* Prints each of the top 10 most frequent words along with its count and its percentage of the total

I should be able to run your program with something like

    $ sbt "run-main dhg.WordCount /Users/dhg/texts/alice.txt"
    Total number of words: 29353
    Top 10 words:
	the     1804    6.15
	and     912     3.11
	to      801     2.73
	a       685     2.33
	of      625     2.13
	it      541     1.84
	she     538     1.83
	said    462     1.57
	you     429     1.46
	in      428     1.46


## Part 3: Removing stopwords

Stopwords are extremely frequent non-content words such as determiners, pronouns, and prepositions.  You'll notice that the top 10 words in the book are all stopwords.  Because they are so frequent, stopwords don't generally tell us much about the content of a document.  Here, you will extend your program to allow for word counting that ignore stopwords.  Update your program to:

* Take a file of stopwords as a command-line parameter with the option `--stopwords FILE`.  (For example: [this one](ftp://ftp.cs.cornell.edu/pub/smart/english.stop))
* If the list of stopwords is present, then skip them in your top-10 display (but not from your total count).
* Ensure that if the stopwords option is not present, that the program will run as in Part 2

I should be able to run your program with something like

    $ sbt "run-main dhg.WordCount /Users/dhg/texts/alice.txt --stopwords /Users/dhg/texts/english.stop"
    Total number of words: 29353
    Top 10 words:
	alice   385     1.31
	project 87      0.30
	thought 74      0.25
	queen   68      0.23
	time    68      0.23
	king    61      0.21
	dont    60      0.20
	began   58      0.20
	im      57      0.19
	mock    56      0.19

This list is a bit more interesting since it shows us words that are actually relevant to the book.


