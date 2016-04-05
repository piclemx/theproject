# GLO-4002

[![build status](https://ci.gitlab.com/projects/7238/status.png?ref=develop)](https://ci.gitlab.com/projects/7238?ref=develop)

## Installation

```
    $ mvn clean package
    $ mvn test
    $ mvn integration-test
    $ cd core && mvn exec:java # lance le serveur
```

## Authors

Équipe #6

 - Marc-Antoine Bouchard Marceau: 111 099 556
 - Alexandre Picard-Lemieux : 111 103 625
 - Raphael Marcoux-Tremblay : 904 181 517
 - Pierre-Luc Vaillant : 111 076 611
 - Nicolas Garneau : 111 050 499
 - Vincent Beaudoin : 111 103 778

## User Stories

 - Accepter une demande minimalement : Terminé
 - Traitement minimal du compte client : Terminé
 - Détecter les demandes erronées : Terminé
 - Accepter les cartes Visa : Terminé
 - Prise en charge du solde client : Terminé
 - Confirmation par le marchand (exacte) : Terminé
 - Détection de la fraude par la distance : Nom terminé (Bonne partie de fait dans la branche feature/detection_fraude)

## Test de performance et fonctionnel de concurrence

Les tests de performance et les tests fonctionnel de concurrence sont situé dans le dossier Jmeter.
