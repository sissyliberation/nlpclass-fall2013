---
layout: default
title: Assignment Requirements
---

## Overview

This page describes the expectations for how you will prepare your coding assignments and submit them for grading.




## GitHub

Your code should be hosted in a *private* GitHub repository.  Follow these instructions:

1. If you do not have an account on GitHub, you need to create one here: [github.com](https://github.com/).
2. Register as a student here: [github.com/edu](https://github.com/edu).  This will give you five free private repositories, one of which will be used for this class.
3. Email me to let me know your GitHub username.  I will grant you "pull" access to the class repository.
4. Fork the course repository: [github.com/utcompling/nlpclass-fall2013](https://github.com/utcompling/nlpclass-fall2013)
5. Check out your fork:
{% highlight text %}
$ git clone git@github.com:USERNAME/nlpclass-fall2013.git
$ cd nlpclass-fall2013
$ git remote add upstream git@github.com:utcompling/nlpclass-fall2013.git
{% endhighlight %}



## Assignment Code

The code for your assignments will be "turned in" via your GitHub repo.  You should probably develop it there too (and you should definitely not develop it in a *public* repo!).

For each assignment, I will create a package in the main repository that contains starter code that you will use in your assignment.  You will pull these changes from the main repo into your fork, and then use this code in completing your assignments.

To pull changes from the upstream (main) class repo, do the following:
{% highlight text %}
git pull upstream master
{% endhighlight %}


TODO: Test to make sure students can't see EACH OTHER'S private forks!!!
 - May need to manually go into utcompling -> teams -> nlpclass-fall2013 and remove student repositories.
