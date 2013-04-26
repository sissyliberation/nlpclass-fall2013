# Course Website


## Updating site

FIRST, commit changes to the website source in `master`.

THEN, in the repository root:

    git checkout master
    cd site
    jekyll
    cd ..
    git checkout gh-pages
    cp -rf site/_site/* .
    git add .
    git commit . -m "updated site"
    git push
    git checkout master


## Development

Start the server:

    jekyll --server
    jekyll --server --auto  # recompiles html files after changes

Browse to:

    http://0.0.0.0:4000






