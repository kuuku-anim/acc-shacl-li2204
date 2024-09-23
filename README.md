<p align="justify">
This is the GitHub repository associated with the paper "A SHACL-based approach for enhancing automated compliance checking with RDF data" by Joseph Anim, Livio Robaldo, and Adam Z. Wyner.
</p>

<p align="justify">
This repository contains the SHACL-based framework presented in the paper as well as the examples discussed therein.
</p>

<p align="justify">
To re-execute the examples locally you must have Java installed. The source code downloadable from this GitHub repository has been developed using Java v19 but it should also work with other versions of the Java Runtime Environment.
</p>

<p align="justify">
If you have Java installed, simply download all files from this repository and write the instruction in the consolle. To compile:
</p>

<p align="center">
<i>javac -cp .;./lib/* executeShapes.java</i><br>
<i>javac -cp .;./lib/* executeRules.java</i>
</p>

<p align="justify">
  To execute:
</p>

<p align="center">
<i>java -cp .;./lib/* -Dfile.encoding=utf-8 executeRules TBox.rdf ABox.rdf rules.rdf</i>
</p>
