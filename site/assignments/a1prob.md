---
layout: default
title: Assignment 1 - Probability
root: "../"
---

**Due: Monday, February 7, 12pm**

This assignment is based on problems 1-5 of [Jason Eisner](http://www.cs.jhu.edu/~jason/)'s [language modeling homework](https://18d120ec-a-e22e9223-s-sites.googlegroups.com/a/utcompling.com/nlp-s11/assignments/homework-1/eisner_lm_homework.pdf?attachauth=ANoY7crnvOj8DTMuEPniMbpaM6TsNW7G1t807GXUnn8-rZO14f7G_L8KTzU4c0c5E5rhcL0WVmS_yyfTN5B045b9SyrXABL8vTbH9ydSWRFcO8PbwlgbDqSbmYKa6VQk4evqMOfM12ArQ9VzhWd-SeHA6xkhiMFxULD7bAUkY5_bb3yIMj10NSm5lnUo_xIpoJy9kv8v6C2lh3sztweVkqhRJy0XfT0rCNbU8lJfp5RayzYAx0yLMDKeLfTrVQBYRoEnBaFwzr_P&attredirects=0) plus a small programming problem (problem 6). Many thanks to Jason E. for making this and other materials for teaching NLP available!

* Answers to problems 1-4 should be hand-written or printed and handed in before class. 

You are welcome to consult books that cover probability theory, such as DeGroot and Schervish or the appendices of [Cormen et al](http://www.amazon.com/Introduction-Algorithms-Thomas-H-Cormen/dp/0262032937), as well as the slides on probability from Dickinson, Eisner and Martin. Also, usage of Wikipedia in conjunction with the course readings, notes and assignments is acceptable (especially if you learn something from it). For this assignment, it may be helpful to consult the following: [Algebra of sets](http://en.wikipedia.org/wiki/Algebra_of_sets) (especially if you're rusty on set theory) and [Bayes' theorem](http://en.wikipedia.org/wiki/Bayes%27_theorem) which is not extensively discussed in Jurafsy & Martin.

There are 70 points total in this assignment. Point values for each problem/sub-problem are given below.



## Problem 1: 33 points 

(3 points per subproblem)

These short problems will help you get the hang of manipulating probabilities. Let `\( \mathcal{E} \neq \emptyset \)` denote the event space (it's just a set, also known as the sample space), and `\( p \)` be a function that assigns a real number in `\( [0,1] \)` to any subset of `\( \mathcal{E} \)`. This number is called the probability of the subset.

You are told that `\( p \)` satisfies the following two axioms:&nbsp; `\( p(\mathcal{E})=1 \)`.&nbsp;&nbsp; `\( p(X \cup Y) = p(X) + p(Y) \)` provided that `\( X \cap Y = \emptyset \)`.

As a matter of notation, remember that the **conditional probability**&nbsp; `\( p(X \mid Y) \stackrel{\tiny{\mbox{def}}}{=} \frac{p(X \cap Z)}{p(Z)} \)`.  For example, singing in the rain is one of my favorite rainy-day activities: so my ratio `\( p(\text{singing} \mid \text{rainy}) = \frac{p(\text{singing}~AND~\text{rainy})}{p(\text{rainy})} \)` is high.  Here the predicate "singing" picks out the set of singing events in `\( \mathcal{E} \)`, "rainy" picks out the set of rainy events, and the conjoined predicate "singing AND rainy" picks out the interesction of these two sets---that is, all the vents that are both singing AND rainy.

1. Prove from the axioms that if `\( Y \subseteq Z \)`, then `\( p(Y) \leq p(Z) \)`.

    You may use any and all set manipulations you like.  Remember that `\( p(A) = 0 \)` does not imply that `\( A = \emptyset \)` (why not?), and similarly, that `\( p(B) = p(C) \)` does not imply that `\( B = C \)` (even if `\( B \subseteq C \)`).

2. Use the above fact to prove that conditional probabilities `\( p(X \mid Z) \)`, just like ordinary probabilities, always fall in the range `\( [0,1]] \)`.

3. Prove from the axioms that `\( p(\emptyset) = 0 \)`.

4. Let `\( \bar{X} \)` denote `\( \mathcal{E} - X \)`.  Prove from the axioms that `\( p(X) = 1-p(\bar{X}) \)`.  For example, `\( p(\text{singing}) = 1 - p(\text{NOT singing}) \)`.

5. Prove from the axioms that `\( p(\text{singing AND rainy} \mid \text{rainy}) = p(\text{singing} \mid \text{rainy}) \)`.

6. Prove from the axioms that `\( p(X \mid Y) = 1 - p(\bar{X} \mid Y) \)`.  For example, `\( p(\text{singing} \mid \text{rainy}) = 1 - p(\text{NOT singing} \mid \text{rainy}) \)`.  This is a generalization of (1.4).

7. Simplify: `\( (p(X \mid Y) \cdot p(Y) + p(X \mid \bar{Y}) \cdot p(\bar{Y})) \cdot p(\bar{Z} \mid X) / p(\bar{Z}) \)`

8. Under what conditions is it true that `\( p(\text{singing OR rainy} = p(\text{singing}) + p(\text{rainy}) \)`?

9. Under what conditions is it true that `\( p(\text{singing AND rainy} = p(\text{singing}) \cdot p(\text{rainy}) \)`?

10.  Suppose you know that `\( p(X \mid Y) = 0 \)`.  Prove that `\( p(X \mid Y,Z) = 0 \)`.

11.  Suppose you know that `\( p(W \mid Y) = 1 \)`.  Prove that `\( p(W \mid Y,Z) = 1 \)`.


## Problem 2: 15 points

All cars are either red or blue.  The witness claimed the car that hit the pedestrian was blue.  Witnesses are bleieved to be about 80% reliable in reporting car color (regardless of the actual car color).  But only 10% of all cars are blue.

1. (1 point) Write an equation relating the following quantities and perhaps other quantities.

    `\[
        \begin{align}
        & p(true = \text{blue})  \\
        & p(true = \text{blue} \mid claimed = \text{blue})  \\
        & p(claimed = \text{blue} \mid true = \text{blue})  
        \end{align}
    \]`

    Reminder: Here, *claimed* and *true* are *random variables*, which means that they are functions over some outcome space.  For example, the probability that *claimed* = blue really means the probability of getting an outcome *x* such that *claimed*(x) = blue.  We are implicitly assumping that the space of outcomes *x* is something like the set of witnessed car accidents.

2. (1 point) Match the three probabilites above with the following terms: *prior probablity*, *likelihood of the evidence*, *posterior probability*.

3. (4 points) Give the values of all three probabilities. (Hint: Use Bayes' Theorem.) Which probability should the judge care about?

4. (4 points) Let's suppose the numbers 80% and 10% are specific to Baltimore. So in the previous problem, you were implicitly using the following more general version of Bayes' Theorem:

    `\[
    p(A \mid B,Y) = \frac{
        p(B \mid A,Y) \cdot p(A \mid Y)
    }{
        p(B \mid Y)
    }
    \]`

    where *Y* is *city* = Baltimore. Just as (1.6) generalized (1.4), by adding a "background" condition *Y*, this version generalizes Bayes' Theorem. Carefully prove it.

5. (4 points) Now prove the more detailed version

    `\[
    p(A \mid B,Y) = \frac{
        p(B \mid A,Y) \cdot p(A \mid Y)
    }{
        p(B \mid A,Y) \cdot p(A \mid Y) + p(B \mid \bar{A},Y) \cdot p(\bar{A} \mid Y)
    }
    \]`

6. (1 point) Write out the equation given in question (2.5) with *A*, *B*, and *Y* replaced by specific propositions from the red-and-blue car problem. For example, *Y* is "*city* = Baltimore" (or just "Baltimore" for short). Now replace the probabilities with actual numbers from the problem, such as 0.8.

    Yeah, it's a mickeymouse problem, but I promise that writing out a real case of this important formula won't kill you, and may even be good for you (like, on an exam).


## Problem 3: 15 points

Beavers can make three cries, which they use to communicate. `bwa` and `bwee` usually mean something like "come" and "go" respectively, and are used during dam maintenance. `kiki` means "watch out!" The following **conditional probability table** shows the probability of the various cries in different situations.

<table class="simple" style="width: 60%;">
    <tr>
        <td><i>p</i>( <i>cry</i> | <i>situation</i> )</td>
        <td>Preditor!</td>
        <td>Timber!</td>
        <td>I need help!</td>
    </tr>
    <tr>
        <td style="text-align: right"><i>bwa</i></td>
        <td>0</td>
        <td>0.1</td>
        <td>0.8</td>
    </tr>
    <tr>
        <td style="text-align: right"><i>bwee</i></td>
        <td>0</td>
        <td>0.6</td>
        <td>0.1</td>
    </tr>
    <tr>
        <td style="text-align: right"><i>kiki</i></td>
        <td>1.0</td>
        <td>0.3</td>
        <td>0.1</td>
    </tr>
</table>

1. (1 point) Notice that each column of the above table sums to 1. Write an equation stating
this, in the form `\( \sum_{variable} p(\cdots) = 1 \)`

2. (4 point) A certain colony of beavers has already cut down all the trees around their dam. As there are no more to chew, *p(timber)* = 0. Getting rid of the trees has also reduced *p(predator)* to 0.2. These facts are shown in the following **joint probability table**. Fill in the rest of the table, using the previous table and the laws of probability. (Note that the meaning of each table is given in its top left cell.)

    <table class="simple" style="width: 80%;">
        <tr>
            <td><i>p</i>( <i>cry</i> | <i>situation</i> )</td>
            <td>Preditor!</td>
            <td>Timber!</td>
            <td>I need help!</td>
            <td>TOTAL</td>
        </tr>
        <tr>
            <td style="text-align: right"><i>bwa</i></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td style="text-align: right"><i>bwee</i></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td style="text-align: right"><i>kiki</i></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td style="text-align: ">TOTAL</td>
            <td>0.2</td>
            <td>0</td>
            <td></td>
            <td></td>
        </tr>
    </table>


3. (10 point, 2 pts per subproblem)  A beaver in this colony cries `kiki`. Given this cry, other beavers try to figure out the probability that there is a predator

    i. This probability is written as: *p*(_________)  
    ii. It can be rewritten without the | symbol as: _________  
    iii. Using the above tables, its value is: _________  
    iv. Alternatively, Bayes' Theorem allows you to express this probability as:
    `\[ \frac{
            p(\_\_\_\_) \cdot p(\_\_\_\_)
        }{
            p(\_\_\_\_) \cdot p(\_\_\_\_) + p(\_\_\_\_) \cdot p(\_\_\_\_) + p(\_\_\_\_) \cdot p(\_\_\_\_)
        }
    \]`  
    v. Using the above tables, the value of this is:  
    `\[ \frac{
            p(\_\_\_\_) \cdot p(\_\_\_\_)
        }{
            p(\_\_\_\_) \cdot p(\_\_\_\_) + p(\_\_\_\_) \cdot p(\_\_\_\_) + p(\_\_\_\_) \cdot p(\_\_\_\_)
        }
    \]`  
        This should give the same result as in part iii., and it should be clear that
        they are really the same computation---by constructing table (b) and doing
        part iii., you were *implicitly* using Bayes' Theorem. (I told you it was a
        trivial theorem!)


## Problem 4: 7 points

![Rube Goldberg's pencil sharpener]({{ page.root }}images/rube_goldberg_pencil_sharpener.jpg)

Rube Goldberg gets his think-tank working and evolves the simplified pencil-sharpener. Open window (A) and  y kite (B). String (C) lifts small door (D) allowing moths (E) to escape and eat red flannel shirt (F). As weight of shirt becomes less, shoe (G) steps on switch (H) which heats electric iron (I) and burns hole in pants (J). Smoke (K) enters hole in tree (L), smoking out opossum (M) which jumps into basket (N), pulling rope (O) and lifting cage (P), allowing woodpecker (Q) to chew wood from pencil (R), exposing lead. Emergency knife (S) is always handy in case opossum or the woodpecker gets sick and can't work.

1\. `\( p(\neg \text{shoe} \mid \neg \text{nail}) = 1 \)`&nbsp;&nbsp; *For want of a nail the shoe was lost*,  
2\. `\( p(\neg \text{horse} \mid \neg \text{shoe}) = 1 \)`&nbsp;&nbsp; *For want of a shoe the horse was lost*,  
3\. `\( p(\neg \text{race} \mid \neg \text{horse}) = 1 \)`&nbsp;&nbsp; *For want of a horse the race was lost*,  
4\. `\( p(\neg \text{fortune} \mid \neg \text{race}) = 1 \)`&nbsp;&nbsp; *For want of a race the fortune was lost*,  

----
5\. `\( p(\neg \text{fortune} \mid \neg \text{nail}) = 1 \)` And all for the want of a horseshoe nail.  

Show carefully that (e) follows from (a)--(d). Hint: Consider
`\[
    p(\neg \text{fortune}, \neg \text{race}, \neg \text{horse}, \neg \text{shoe} \mid \neg \text{nail}),
\]`
as well as the "chain rule" and problems (1.1), (1.2), and (1.11).

*Note:* The `\( \neg \)` symbol denotes the boolean operator NOT.

*Note:* This problem is supposed to convince you that logic is just a special case of probability theory.

*Note:* Be glad I didn't ask you to prove the correct operation of the pencil sharpener!



## Problem 5: XX points

This problem builds on the work done in [Assingment 0, Problem 6](assignment0programming.html).  For that problem we read a file containing features and labels and computed both label counts and feature counts.  In this problem we will write code that computes probability distributions.  

For this task, you will implement two classes
1. `nlp.a1.ProbabilityDistribution` that extends `nlpclass.ProbabilityDistributionToImplement`
2. `nlp.a1.ConditionalProbabilityDistribution` that extends `nlpclass.ConditionalProbabilityDistributionToImplement`
3. {% highlight scala %}nlp.a1.ProbabilityDistribution{% endhighlight %} that extends {% highlight scala %}nlpclass.ProbabilityDistributionToImplement{% endhighlight %}








