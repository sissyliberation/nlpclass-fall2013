rm -rf target/scala-2.10/nlpclass-fall2013_2.10-*
sbt publish

for f in target/scala-2.10/nlpclass-fall2013_2.10-*
do
  version=${f:41:4}
  dir=public_html/maven-repository/snapshots/utcompling/nlpclass-fall2013_2.10/$version/
  ssh k mkdir -p $dir
  scp $f k:$dir
done
