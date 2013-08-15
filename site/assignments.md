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
3. Create a new repository for your classwork by clicking on "New Repository" on the GitHub website.  Be sure to select ***PRIVATE*** repository.
4. Add me as a "collaborator".  Do this from the GitHub webpage for your repository: `Settings` `->` `Collaborators` `->` `Add a friend` and enter my username: `dhgarrette`.
5. Clone your repositiory.
    {% highlight text %}$ git clone git@github.com:USERNAME/REPOSITORY-NAME.git{% endhighlight %}
6. Follow the instructions on the [Scala Environment Setup]({{ page.root }}scala/setup.html) page to create a scala project in your repository directory.
7. Add the following to your main `build.sbt`:
    {% highlight text %}
resolvers ++= Seq(
  "dhg releases repo" at "http://www.cs.utexas.edu/~dhg/maven-repository/releases",
  "dhg snapshot repo" at "http://www.cs.utexas.edu/~dhg/maven-repository/snapshots"
)
    
libraryDependencies += "utcompling" % "nlpclass-fall2013_2.10" % "0001" changing(){% endhighlight %}

    This creates a dependency from your project to the course project code, which exists online.  I will use this project to provide code to you that your code can access.

    Whenever I update this dependency, I will push a new version online with a new version number.  The first version number is `0001`, and I will tell you each time I increment it.  When I do, you will have to correspondingly update the number in this file.


## Assignment Code

The code for your assignments will be "turned in" via your GitHub repo.  You should probably develop it there too (and you should definitely not develop it in a *public* repository!).

For each assignment, I will create a package in the main repository that contains starter code that you will use in your assignment.  You will pull these changes from the main repo into your fork, and then use this code in completing your assignments.

To pull changes from the upstream (main) class repo, do the following:
{% highlight text %}
git pull upstream master
{% endhighlight %}
