Bare en enkel test på å nyhetslinker fra en Atom feed hos VG.

Planen er å bruke teknologier som:

* SpringBoot
* Apache Camel
* Apache ActiveMQ
* mysql
* Atom feed
* WireMock standalone
* m.m.


Skal lagre elementer på Apache ActiveMQ
Full historikk og "peker" i en mySql base

ny "entry" fra vg kan komme og forsvinne litt når den publiseres. Medfører at kontollen med siste
innleste element går til h******. Løser dette med å implementere Camel idempotent consumer.

http://camel.apache.org/idempotent-consumer.html

