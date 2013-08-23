package nlpclass

/**
 * For Assignment 0 - Part 5: Counting n-grams
 */
trait NGramCountingToImplement {

  /**
   * Given a vector of words, return a mapping from ngrams
   * to their counts.
   */
  def countNGrams(ngrams: Vector[String]): Map[Vector[String], Int]

}

/**
 * For Assignment 1 - Part 5:
 */
trait ProbabilityDistributionToImplement {
  def apply(x: String): Double
}

/**
 * For Assignment 1 - Part 5:
 */
trait ConditionalProbabilityDistributionToImplement {
  def apply(x: String, given: String): Double
}

/**
 * For Assignment 1 - Part 5:
 */
trait FeatureProbabilityDistributionsFactoryToImplement {
  def fromFile(filename:String): (ProbabilityDistributionToImplement, Map[String,ConditionalProbabilityDistributionToImplement])
}
