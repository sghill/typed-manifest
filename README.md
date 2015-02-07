Typed Manifest
==============

Provides easy access to `META-INF/MANIFEST.MF` on the classpath.


Usage
-----
See the `samples` module.


Back Story
----------
I was building an executable uberjar and correctly populating the
`Implementation-Version` of `META-INF/MANIFEST.MF`. I wanted the manifest
to be the sole source of truth for that information, but I also wanted to
print it when invoking `java -jar myjar.jar --version`. This code isn't unique
to my application, so here it is as a reusable jar.


License
-------

    Copyright 2015 Steve Hill

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
