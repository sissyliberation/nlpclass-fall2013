package nlpclass

////////////////////////////////
// Assignment 0
////////////////////////////////

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

////////////////////////////////
// Assignment 1
////////////////////////////////

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
trait FeatureFileAsDistributionsToImplement {
  def fromFile(filename: String): (Set[String], ProbabilityDistributionToImplement[String], Map[String, ConditionalProbabilityDistributionToImplement[String, String]])
}

////////////////////////////////
// Assignment 2
////////////////////////////////

/**
 * For Assignment 2 - Part 2:
 */
trait NaiveBayesModelToImplement[Label, Feature, Value] {
  def predict(features: Vector[(Feature, Value)]): Label
}

/**
 * For Assignment 2 - Part 2:
 */
trait NaiveBayesTrainerToImplement[Label, Feature, Value] {
  def train(instances: Vector[(Label, Vector[(Feature, Value)])]): NaiveBayesModelToImplement[Label, Feature, Value]
}
