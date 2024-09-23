<p align="justify">
This is the GitHub repository associated with the paper "On the interplay between entailments among obligations and their violations" by Livio Robaldo, submitted to JURISIN 2025.
</p>

<p align="justify">
This repository contains the computational ontology proposed in the paper as well as all examples shown and discussed therein. This ontology extends <a href="https://github.com/liviorobaldo/conflict-tolerantDeonticTraditionalScheme">the ontology defined in this other GitHub repository</a>. Therefore,besides downloading the files from this GitHub, you must also download the file:
</p>
<p align="center">
  <a href="https://github.com/liviorobaldo/conflict-tolerantDeonticTraditionalScheme/blob/main/ctDTS.ttl">https://github.com/liviorobaldo/conflict-tolerantDeonticTraditionalScheme/blob/main/ctDTS.ttl</a>
</p>

<p align="justify">
To re-execute the examples locally you must have Java installed. The source code downloadable from this GitHub repository has been developed using Java v19 but it should also work with other versions of the Java Runtime Environment.
</p>

<p align="justify">
If you have Java installed, simply download all files from this repository and write the following in the consolle:
</p>

<p align="center">
<i>java -cp .;./lib/* -Dfile.encoding=utf-8 ctDTSreasonerPlusViolationsAndPenalties<br> ctDTS.ttl VaP.ttl ./Examples/Example1.ttl inferredABox.ttl</i>
</p>

<p align="justify">
The SPARQL rules in the files ctDTS.ttl and VaP.ttl will be executed on the state of affairs in the file Example1.ttl and the result will be written in the file inferredABox.ttl. To run the other examples, just modify the second parameter.
</p>
