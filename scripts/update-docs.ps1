mvn -T1C clean javadoc:javadoc
New-Item -type directory -Path javadoc -Force
Copy-Item -Path typed-manifest\target\site\apidocs -Recurse -Destination javadoc
git add javadoc
git checkout gh-pages
git clean -xdf
git commit -m 'Update javadoc'
git checkout master

