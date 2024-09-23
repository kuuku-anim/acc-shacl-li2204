<p style="align:justify">
This repository contains the solution presented in the paper "A SHACL-based approach for enhancing automated compliance checking with RDF data"
</p>

<p style="align:justify">
The solution has been developed in Java v19 but it should also work with other versions of the Java Runtime Environment.
</p>

<p style="align:justify">
If you have Java installed, simply download all files from this repository and write the following in the consolle:
</p>

<p style="align:justify">
<i>java -cp .;./lib/* -Dfile.encoding=utf-8 ctDTSreasonerPlusViolationsAndPenalties</i>
<i>ctDTS.ttl VaP.ttl ./Examples/Example1.ttl inferredABox.ttl</i>
</p>

<p style="align:justify">
The SPARQL rules in the files ctDTS.ttl and VaP.ttl will be executed on the state of affairs in the file Example1.ttl and the result will be written in the file inferredABox.ttl. To run the other examples, just modify the second parameter.
</p>
