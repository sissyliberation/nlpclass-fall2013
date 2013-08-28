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
trait ProbabilityDistributionToImplement[B] {
  def apply(x: B): Double
  def generate: B
}

/**
 * For Assignment 1 - Part 5:
 */
trait ConditionalProbabilityDistributionToImplement[A, B] {
  def apply(x: B, given: A): Double
  def generate(given: A): B
}

/**
 * For Assignment 1 - Part 5:
 */
trait FeatureProbabilityDistributionsFactoryToImplement {
  def fromFile(filename: String): (ProbabilityDistributionToImplement[String], Map[String, ConditionalProbabilityDistributionToImplement[String, String]])
}
