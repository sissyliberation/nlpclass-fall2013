---
layout: default
title: Assignment 0 - Programming in Scala
root: "../"
---

**Due: Thursday, September 5, 2pm**

This course will require you to complete several non-trivial programming assignments.  As such, to be successful in this class you must be comfortable programming.  The primary purpose of this assignment is for you to ensure that you have at least a minimum level programming competence.  

**All of the programming assignments for the rest of the course will be more difficult than this one.  If you find this assignment excessively difficult, then this course may not be for you.**

If you have questions, or want to discuss whether you think the course is a good fit for you, please do not hesitate to talk to me.  


## Overview

In this assignment, you will write code for reading texts from file and calculating basic statistics about that data.  This code will be used in subsequent programming assignments since all future assignments will require working with texts.

In the root of your repository, create a file called `Assignment0_README.md` that contains:
* A short overview of what you've done
* A list of files relevant to this assignment
* Any commands needed to demonstrate your programs

You are highly encouraged to make your code as modular as possible, to facilitate reuse.  Functions like reading a file, cleaning it up, and counting things are going to be used all the time in this course.  Having easy-to-call functions for these operations in your code will serve you well.

You may discuss programming assignments with your classmates.  And google is an invaluable programming asset (in school and in the real world), so use it well.  But avoid looking for exact answers on google or having classmates give you exact solutions.  And *please* don't post these assignments to StackOverflow asking people to do your work for you.  The point of these programming assignments is to reinforce the material; copying and pasting from the internet defeats that purpose.  The goal is to learn something, to practice programming, to develop critical thinking skills, and, hopefully, to have fun.


## Part 1: Getting set up

Follow the instructions on the [Assignment Requirements]({{ page.root }}assignments.html) and [Scala Environment Setup]({{ page.root }}scala/setup.html) pages.  At a minimum, you'll need to:

* Download and install Scala
* Download and install SBT
* Create a Github Account and register as a student
* Create a ***PRIVATE*** GitHub repository for your code with the name
    {% highlight text %}nlpclass-fall2013-<lastname>-<firstname>{% endhighlight %}
    and clone it to your computer
* Add me (GitHub username `dhgarrette`) as a "collaborator"
* Create a Scala project in (the root of) your repository with `nlpclass-fall2013` as a dependency


## Part 2: Counting words

Download [Alice's Adventures in Wonderland](http://www.gutenberg.org/cache/epub/11/pg11.txt) from Project Gutenberg.

Write an application that does the following:

* Takes a file path of as a command-line argument.
* Removes all punctuation and numbers and lowercases all words.
* Prints the total number of words in the book.
* Prints the number of *distinct* words in the book.
* Prints each of the top 10 most frequent words along with its count and its percentage of the total.

The application should be in an `object` called `WordCount` in a package called `nlp`.  I should be able to run your program with something like this, and get this exact output:

    $ cd nlpclass-fall2013-<lastname>-<firstname>
    $ sbt "run-main nlp.WordCount /Users/dhg/texts/alice.txt"
    Total number of words: 29353
    Number of distinct words: 3203
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

Stopwords are extremely frequent non-content words such as determiners, pronouns, and prepositions.  You'll notice that the top 10 words in the book are all stopwords.  Because they are so frequent, stopwords don't generally tell us much about the content of a document.  

Here, you will extend your program to allow for word counting that ignore stopwords.  Update your program to:

* Take a file of stopwords as a command-line parameter with the option `--stopwords FILE`.  (For example: [this one](ftp://ftp.cs.cornell.edu/pub/smart/english.stop)).
* If the list of stopwords is present, then skip them in your top-10 display (but don't exclude them from your total count).
* Ensure that if the stopwords option is not present, that the program will run as in Part 2.

I should be able to run your program with something like this, and get this exact output:

    $ sbt "run-main nlp.WordCount alice.txt --stopwords english.stop"
    Total number of words: 29353
    Number of distinct words: 3203
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


## Part 4: Word count distribution

The distributions of words in a document are always highly skewed: a few words appear with very high frequencies, but most words appear very few times.  To get an idea of the shape of things, write a program called `WordFreqFreq` that prints the ten most frequent frequencies and the five least frequent frequencies.  

Your output should be obviously be sorted by frequency frequency, but for frequencies with the same frequency frequency, you should sort by frequency.  Confused yet?  

I should be able to run your program with something like this, and get this exact output:

    $ sbt "run-main nlp.WordFreqFreq /Users/dhg/texts/alice.txt"
    Top 10 most frequent frequencies:
	1508 words appear 1 time
	493 words appear 2 times
	265 words appear 3 times
	175 words appear 4 times
	112 words appear 5 times
	70 words appear 7 times
	66 words appear 6 times
	66 words appear 8 times
	42 words appear 10 times
	35 words appear 9 times

    Bottom 5 most frequent frequencies:
	1 word appears 625 times
	1 word appears 685 times
	1 word appears 801 times
	1 word appears 912 times
	1 word appears 1804 times

*Note:* your output needs to be grammatical.

So more than half the words in the book appear only once (1508 out of 3203).

I plotted a graph of the frequency distribution:

<a href="{{ page.root }}images/aliceFreqDist.png"><img src="{{ page.root }}images/aliceFreqDist.png" border="0" style="border:none;max-width:100%;" alt="Word Frequency Distribution" /></a>


## Part 5: Counting n-grams

An **n-gram** is a sequence of *n* words.  We will be talking a lot more about n-grams later in this course, but for now we're just going to count them.

In future exercises, I'll be giving you a `trait` and asking you to implement it.  To make sure that this makes sense, here is a simple example.  

In the `nlpclass-fall2013` jar that your project should have as a dependency, there is a trait [`nlpclass.NGramCountingToImplement`](https://github.com/utcompling/nlpclass-fall2013/blob/master/src/main/scala/nlpclass/AssignmentTraits.scala#L6).  It looks like this:

{% highlight scala %}
trait NGramCountingToImplement {

  /**
   * Given a vector of words, return a mapping from ngrams 
   * to their counts.
   */
  def countNGrams(ngrams: Vector[String]): Map[Vector[String], Int]

}
{% endhighlight %}

Your task is to implement this trait.  You should create a file that looks like this:

{% highlight scala %}
package nlp

import nlpclass.NGramCountingToImplement

class NGramCounting(n: Int) extends NGramCountingToImplement {

  def countNGrams(ngrams: Vector[String]): Map[Vector[String], Int] = {
     ???  // Your code here
  }

}
{% endhighlight %}

and implement the method `countNGrams`.&nbsp; *Hint:* See `Vector.sliding` in the [API](http://www.scala-lang.org/api/current/#scala.collection.immutable.Vector).

I'm going to test your class like this:

{% highlight scala %}
scala> new NGramCounting(3).countNGrams(aliceText)(Vector("the", "white", "rabbit"))
res0: Int = 21
{% endhighlight %}

Now write a program called `CountTrigrams` that prints the top 10 most frequent trigrams along with their counts. I should be able to run your program with something like this, and get this exact output:

    $ sbt "run-main nlp.CountTrigrams /Users/dhg/texts/alice.txt"
	the mock turtle                 51
	the march hare                  30
	said the king                   29
	the white rabbit                21
	said the hatter                 21
	said to herself                 19
	said the mock                   19
	project gutenbergtm electronic  18
	said the caterpillar            18
	she said to                     17

Just for fun: of the 25,322 distinct trigrams, 23,093 (91%) appear only once, and 99.9% appear 11 times or fewer!
