# Data Collation Entities

This project implements entities maintained by the data collation system. Each
of the centres submit a large amount of data. These are submitted as XML
documents using a data format that makes standardisation and data validation
easier. When the PhenoDCC receives these XML documents, they are stored verbatim
in the `phenodcc_raw` database.

_The database schema is defined elsewhere as XSD documents_. In this
project we only define entities that are used by
[Phenoview](https://www.mousephenotype.org/phenoview).
