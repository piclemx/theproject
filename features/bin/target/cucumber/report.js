$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("analyse-compte-client.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: fr"
    }
  ],
  "line": 2,
  "name": "Analyser en fonction du compte client",
  "description": "Afin d\u0027éviter la fraude et le dépasser des capacité de paiement\nEn tant que compagnie de carte de crédit\nJe veux effectuer des vérification sur le compte client",
  "id": "analyser-en-fonction-du-compte-client",
  "keyword": "Fonctionnalité"
});
formatter.before({
  "duration": 3170956893,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Demandes avec un numéro de carte de crédit inexistant",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-numéro-de-carte-de-crédit-inexistant",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 8,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 9,
  "name": "un numéro de carte associé à aucun compte",
  "keyword": "Et "
});
formatter.step({
  "line": 10,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 11,
  "name": "la demande est refusée",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 186671145,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.un_numero_de_carte_associe_a_aucun_compte()"
});
formatter.result({
  "duration": 27119,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 1684153774,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refusee()"
});
formatter.result({
  "duration": 427739242,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 13,
  "name": "Demandes avec une carte expirée",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée",
  "type": "scenario_outline",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 14,
  "name": "que la date d\u0027aujourd\u0027hui est le 02/15",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 15,
  "name": "une demande avec une date d\u0027expiration \u003cdate_exp\u003e pour la carte",
  "keyword": "Et "
});
formatter.step({
  "line": 16,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 17,
  "name": "la demande est \u003cjugement\u003e",
  "keyword": "Alors "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;",
  "rows": [
    {
      "cells": [
        "date_exp",
        "jugement"
      ],
      "line": 20,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;1"
    },
    {
      "cells": [
        "01/14",
        "refusé"
      ],
      "line": 21,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;2"
    },
    {
      "cells": [
        "01/15",
        "refusé"
      ],
      "line": 22,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;3"
    },
    {
      "cells": [
        "02/15",
        "ok"
      ],
      "line": 23,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;4"
    },
    {
      "cells": [
        "03/15",
        "ok"
      ],
      "line": 24,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;5"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 24002,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Demandes avec une carte expirée",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;2",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 14,
  "name": "que la date d\u0027aujourd\u0027hui est le 02/15",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 15,
  "name": "une demande avec une date d\u0027expiration 01/14 pour la carte",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 16,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 17,
  "name": "la demande est refusé",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "02",
      "offset": 33
    },
    {
      "val": "15",
      "offset": 36
    }
  ],
  "location": "TransactionRequestContext.que_la_date_d_aujourd_hui_est_le_(int,int)"
});
formatter.result({
  "duration": 11502536,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01/14",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration_pour_la_carte(String)"
});
formatter.result({
  "duration": 3157722,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 71520978,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refuse()"
});
formatter.result({
  "duration": 8955455,
  "status": "passed"
});
formatter.before({
  "duration": 36653,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Demandes avec une carte expirée",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;3",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 14,
  "name": "que la date d\u0027aujourd\u0027hui est le 02/15",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 15,
  "name": "une demande avec une date d\u0027expiration 01/15 pour la carte",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 16,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 17,
  "name": "la demande est refusé",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "02",
      "offset": 33
    },
    {
      "val": "15",
      "offset": 36
    }
  ],
  "location": "TransactionRequestContext.que_la_date_d_aujourd_hui_est_le_(int,int)"
});
formatter.result({
  "duration": 6650697,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01/15",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration_pour_la_carte(String)"
});
formatter.result({
  "duration": 3644104,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 31048049,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refuse()"
});
formatter.result({
  "duration": 8991190,
  "status": "passed"
});
formatter.before({
  "duration": 21282,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Demandes avec une carte expirée",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;4",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 14,
  "name": "que la date d\u0027aujourd\u0027hui est le 02/15",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 15,
  "name": "une demande avec une date d\u0027expiration 02/15 pour la carte",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 16,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 17,
  "name": "la demande est ok",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "02",
      "offset": 33
    },
    {
      "val": "15",
      "offset": 36
    }
  ],
  "location": "TransactionRequestContext.que_la_date_d_aujourd_hui_est_le_(int,int)"
});
formatter.result({
  "duration": 7908939,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "02/15",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration_pour_la_carte(String)"
});
formatter.result({
  "duration": 1969473,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 53919064,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_ok()"
});
formatter.result({
  "duration": 8892456,
  "status": "passed"
});
formatter.before({
  "duration": 20174,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Demandes avec une carte expirée",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-une-carte-expirée;;5",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 14,
  "name": "que la date d\u0027aujourd\u0027hui est le 02/15",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 15,
  "name": "une demande avec une date d\u0027expiration 03/15 pour la carte",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 16,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 17,
  "name": "la demande est ok",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "02",
      "offset": 33
    },
    {
      "val": "15",
      "offset": 36
    }
  ],
  "location": "TransactionRequestContext.que_la_date_d_aujourd_hui_est_le_(int,int)"
});
formatter.result({
  "duration": 5951731,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "03/15",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration_pour_la_carte(String)"
});
formatter.result({
  "duration": 2719003,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 35540070,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_ok()"
});
formatter.result({
  "duration": 8028837,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Demandes avec un montant excédant le solde",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde",
  "type": "scenario_outline",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 27,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 28,
  "name": "une carte de crédit associée à un compte avec une limite de crédit de 1200",
  "keyword": "Et "
});
formatter.step({
  "line": 29,
  "name": "un montant demandé de \u003cmontant\u003e",
  "keyword": "Et "
});
formatter.step({
  "line": 30,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est \u003cjugement\u003e",
  "keyword": "Alors "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;",
  "rows": [
    {
      "cells": [
        "montant",
        "jugement"
      ],
      "line": 34,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;1"
    },
    {
      "cells": [
        "1000",
        "ok"
      ],
      "line": 35,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;2"
    },
    {
      "cells": [
        "1200",
        "ok"
      ],
      "line": 36,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;3"
    },
    {
      "cells": [
        "2000",
        "refusé"
      ],
      "line": 37,
      "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;4"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 20615,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Demandes avec un montant excédant le solde",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;2",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 27,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 28,
  "name": "une carte de crédit associée à un compte avec une limite de crédit de 1200",
  "keyword": "Et "
});
formatter.step({
  "line": 29,
  "name": "un montant demandé de 1000",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 30,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est ok",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 8804651,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1200",
      "offset": 70
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_associee_a_un_compte_avec_une_limite_de_credit_de_(int)"
});
formatter.result({
  "duration": 4891754,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1000",
      "offset": 22
    }
  ],
  "location": "TransactionRequestContext.un_montant_demande_de_(float)"
});
formatter.result({
  "duration": 185811,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 36769384,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_ok()"
});
formatter.result({
  "duration": 9502325,
  "status": "passed"
});
formatter.before({
  "duration": 17943,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Demandes avec un montant excédant le solde",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;3",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 27,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 28,
  "name": "une carte de crédit associée à un compte avec une limite de crédit de 1200",
  "keyword": "Et "
});
formatter.step({
  "line": 29,
  "name": "un montant demandé de 1200",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 30,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est ok",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 6307449,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1200",
      "offset": 70
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_associee_a_un_compte_avec_une_limite_de_credit_de_(int)"
});
formatter.result({
  "duration": 9193187,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1200",
      "offset": 22
    }
  ],
  "location": "TransactionRequestContext.un_montant_demande_de_(float)"
});
formatter.result({
  "duration": 93689,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 35288622,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_ok()"
});
formatter.result({
  "duration": 10957763,
  "status": "passed"
});
formatter.before({
  "duration": 29379,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Demandes avec un montant excédant le solde",
  "description": "",
  "id": "analyser-en-fonction-du-compte-client;demandes-avec-un-montant-excédant-le-solde;;4",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 27,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 28,
  "name": "une carte de crédit associée à un compte avec une limite de crédit de 1200",
  "keyword": "Et "
});
formatter.step({
  "line": 29,
  "name": "un montant demandé de 2000",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 30,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est refusé",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 16948421,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1200",
      "offset": 70
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_associee_a_un_compte_avec_une_limite_de_credit_de_(int)"
});
formatter.result({
  "duration": 5663881,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2000",
      "offset": 22
    }
  ],
  "location": "TransactionRequestContext.un_montant_demande_de_(float)"
});
formatter.result({
  "duration": 108349,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 36482853,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refuse()"
});
formatter.result({
  "duration": 8604262,
  "status": "passed"
});
formatter.uri("confirmation-marchand.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: fr"
    }
  ],
  "line": 2,
  "name": "Confirmation par le marchand",
  "description": "Afin d\u0027être payé\nEn tant que marchand\nJe peux confirmer les transactions passées avec le montant final",
  "id": "confirmation-par-le-marchand",
  "keyword": "Fonctionnalité"
});
formatter.before({
  "duration": 29048,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Soumission de transactions admissibles",
  "description": "",
  "id": "confirmation-par-le-marchand;soumission-de-transactions-admissibles",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 8,
  "name": "un marchand avec des transactions admissibles en attente",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 9,
  "name": "il soumet les transactions",
  "keyword": "Quand "
});
formatter.step({
  "line": 10,
  "name": "les transactions sont confirmées",
  "keyword": "Alors "
});
formatter.match({
  "location": "VendorConfirmationContext.un_marchand_avec_des_transactions_admissibles_en_attente()"
});
formatter.result({
  "duration": 10605669,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.il_soumet_des_transactions()"
});
formatter.result({
  "duration": 243679095,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.les_transactions_sont_confirmees()"
});
formatter.result({
  "duration": 17306192,
  "status": "passed"
});
formatter.before({
  "duration": 24555,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Soumission de transactions par un marchand n\u0027ayant aucune transaction à son effectif",
  "description": "",
  "id": "confirmation-par-le-marchand;soumission-de-transactions-par-un-marchand-n\u0027ayant-aucune-transaction-à-son-effectif",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 13,
  "name": "un marchand sans transaction",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 14,
  "name": "il soumet aucune transaction",
  "keyword": "Quand "
});
formatter.step({
  "line": 15,
  "name": "rien n\u0027est effectué",
  "keyword": "Alors "
});
formatter.step({
  "line": 16,
  "name": "aucune erreur n’est reportée",
  "keyword": "Et "
});
formatter.match({
  "location": "VendorConfirmationContext.un_marchand_sans_transaction()"
});
formatter.result({
  "duration": 4565596,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.il_soumet_aucune_transaction()"
});
formatter.result({
  "duration": 23407741,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.rien_est_effectue()"
});
formatter.result({
  "duration": 41071,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.aucune_erreur_reportee()"
});
formatter.result({
  "duration": 672504,
  "status": "passed"
});
formatter.before({
  "duration": 31467,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Soumission d\u0027une transaction déjà confirmée",
  "description": "",
  "id": "confirmation-par-le-marchand;soumission-d\u0027une-transaction-déjà-confirmée",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 19,
  "name": "une transaction déjà confirmée",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 20,
  "name": "le marchand soumet cette transaction",
  "keyword": "Quand "
});
formatter.step({
  "line": 21,
  "name": "la transaction reste dans son statut actuel",
  "keyword": "Alors "
});
formatter.match({
  "location": "VendorConfirmationContext.une_transaction_deja_confirmee()"
});
formatter.result({
  "duration": 8869440,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.le_marchand_soumet_cette_transaction()"
});
formatter.result({
  "duration": 20087783,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.la_transaction_reste_dans_son_statut_actuel()"
});
formatter.result({
  "duration": 5123043,
  "status": "passed"
});
formatter.before({
  "duration": 31954,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Soumission de transactions ayant une transaction inadmissible",
  "description": "",
  "id": "confirmation-par-le-marchand;soumission-de-transactions-ayant-une-transaction-inadmissible",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 24,
  "name": "un marchand avec des transactions admissibles",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 25,
  "name": "ayant des transactions inadmissible",
  "keyword": "Et "
});
formatter.step({
  "line": 26,
  "name": "il soumet les transactions inadmissibles",
  "keyword": "Quand "
});
formatter.step({
  "line": 27,
  "name": "aucune transaction n’est confirmée",
  "keyword": "Alors "
});
formatter.step({
  "line": 28,
  "name": "la requête est rejetée",
  "keyword": "Et "
});
formatter.match({
  "location": "VendorConfirmationContext.un_marchand_avec_des_transactions_admissibles()"
});
formatter.result({
  "duration": 9345061,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.ayant_des_transactions_inadmissibles()"
});
formatter.result({
  "duration": 6277902,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.il_soumet_les_transactions_inadmissibles()"
});
formatter.result({
  "duration": 51457430,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.auncune_transaction_est_confirmee()"
});
formatter.result({
  "duration": 26696,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.la_requete_est_rejetee()"
});
formatter.result({
  "duration": 349780,
  "status": "passed"
});
formatter.before({
  "duration": 18592,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Soumission de transactions par un marchand inexistant",
  "description": "",
  "id": "confirmation-par-le-marchand;soumission-de-transactions-par-un-marchand-inexistant",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 31,
  "name": "un numéro de marchand inexistant",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 32,
  "name": "le marchand inexistant soumet une liste de transaction",
  "keyword": "Quand "
});
formatter.step({
  "line": 33,
  "name": "la resource est donc introuvable",
  "keyword": "Alors "
});
formatter.match({
  "location": "VendorConfirmationContext.un_numero_marchand_inexistant()"
});
formatter.result({
  "duration": 74548,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.le_marchand_inexistant_soumet_une_liste_de_transaction()"
});
formatter.result({
  "duration": 15434799,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.resource_introuvable()"
});
formatter.result({
  "duration": 357316,
  "status": "passed"
});
formatter.before({
  "duration": 20264,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Soumission de transactions inexistantes",
  "description": "",
  "id": "confirmation-par-le-marchand;soumission-de-transactions-inexistantes",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 36,
  "name": "des transactions inexistante",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 37,
  "name": "le marchand soumet ces transactions inexistantes",
  "keyword": "Quand "
});
formatter.step({
  "line": 38,
  "name": "une erreur se produit",
  "keyword": "Alors "
});
formatter.match({
  "location": "VendorConfirmationContext.des_transactions_inexistantes()"
});
formatter.result({
  "duration": 1436276,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.marchand_soumet_transactions_inexistantes()"
});
formatter.result({
  "duration": 24466115,
  "status": "passed"
});
formatter.match({
  "location": "VendorConfirmationContext.une_erreur_se_produit()"
});
formatter.result({
  "duration": 343216,
  "status": "passed"
});
formatter.uri("detection-fraude-distance.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: fr"
    }
  ],
  "line": 2,
  "name": "Détection automatique de la fraude par la distance en km",
  "description": "Afin d\u0027arrêter le plus rapidement possible les dépenses frauduleuses\nEn tant que compagnie de crédit\nJe veux détecter les achats humainement impossibles à cause de la distance en km par rapport au temps",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km",
  "keyword": "Fonctionnalité"
});
formatter.before({
  "duration": 18764,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Code postal de la demande non reconnu",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;code-postal-de-la-demande-non-reconnu",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 8,
  "name": "un code postal non reconnu",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 9,
  "name": "je fais un achat à ce code postal",
  "keyword": "Quand "
});
formatter.step({
  "line": 10,
  "name": "la demande est considérée non frauduleuse",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.un_code_postal_non_reconnu()"
});
formatter.result({
  "duration": 15359342,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.je_fais_un_achat_a_ce_code_postal()"
});
formatter.result({
  "duration": 38606823,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_non_frauduleuse()"
});
formatter.result({
  "duration": 11701352,
  "status": "passed"
});
formatter.before({
  "duration": 691261,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Utilisation d\u0027une carte bloquée",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;utilisation-d\u0027une-carte-bloquée",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 13,
  "name": "une carte bloquée",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 14,
  "name": "une demande est soumise avec cette carte",
  "keyword": "Quand "
});
formatter.step({
  "line": 15,
  "name": "la demande est refusée",
  "keyword": "Alors "
});
formatter.step({
  "line": 16,
  "name": "le service de fraude est informé",
  "keyword": "Et "
});
formatter.match({
  "location": "TransactionRequestContext.une_carte_bloquée()"
});
formatter.result({
  "duration": 10004739,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_est_soumise_avec_cette_carte()"
});
formatter.result({
  "duration": 319811800,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refusee()"
});
formatter.result({
  "duration": 9965583,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_service_de_fraude_est_informe()"
});
formatter.result({
  "duration": 5289006,
  "status": "passed"
});
formatter.before({
  "duration": 31145,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Utilisation d\u0027une carte considérée frauduleuse",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;utilisation-d\u0027une-carte-considérée-frauduleuse",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 19,
  "name": "une carte rapportée frauduleuse",
  "keyword": "Étant donnée "
});
formatter.step({
  "line": 20,
  "name": "une demande est soumise avec cette carte",
  "keyword": "Quand "
});
formatter.step({
  "line": 21,
  "name": "le service de fraude est alerté",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_carte_rapportee_frauduleuse()"
});
formatter.result({
  "duration": 5475487,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_est_soumise_avec_cette_carte()"
});
formatter.result({
  "duration": 204872406,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_service_de_fraude_est_alerte()"
});
formatter.result({
  "duration": 510315,
  "status": "passed"
});
formatter.before({
  "duration": 51092,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Impossibilité de trouver la distance",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;impossibilité-de-trouver-la-distance",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 24,
  "name": "je traite une demande",
  "keyword": "Quand "
});
formatter.step({
  "line": 25,
  "name": "qu\u0027il n\u0027est pas possible de trouver la distance",
  "keyword": "Et "
});
formatter.step({
  "line": 26,
  "name": "la demande est considérée non frauduleuse",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.je_traite_une_demande()"
});
formatter.result({
  "duration": 14887131,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.il_nest_pas_possible_de_trouver_la_distance()"
});
formatter.result({
  "duration": 635984308,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_non_frauduleuse()"
});
formatter.result({
  "duration": 22501656,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 28,
  "name": "Historique avec des codes postaux non reconnus",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus",
  "type": "scenario_outline",
  "keyword": "Plan du Scénario"
});
formatter.step({
  "line": 29,
  "name": "la transaction au \u003ccode_postal\u003e à \u003cheure\u003e dans l\u0027historique",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 30,
  "name": "je fais un achat au 33142 à 2015-01-01 14:00:00 UTC",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est considérée comme frauduleuse",
  "keyword": "Alors "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;",
  "rows": [
    {
      "cells": [
        "code_postal",
        "heure"
      ],
      "line": 34,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;1"
    },
    {
      "cells": [
        "G1T 1H5",
        "2015-01-01 13:00:00 UTC"
      ],
      "line": 35,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;2"
    },
    {
      "cells": [
        "XXX XXX",
        "2015-01-01 13:15:00 UTC"
      ],
      "line": 36,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;3"
    },
    {
      "cells": [
        "XXX XXX",
        "2015-01-01 13:30:00 UTC"
      ],
      "line": 37,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;4"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 28894,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Historique avec des codes postaux non reconnus",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;2",
  "type": "scenario",
  "keyword": "Plan du Scénario"
});
formatter.step({
  "line": 29,
  "name": "la transaction au G1T 1H5 à 2015-01-01 13:00:00 UTC dans l\u0027historique",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 30,
  "name": "je fais un achat au 33142 à 2015-01-01 14:00:00 UTC",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est considérée comme frauduleuse",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "G1T 1H5",
      "offset": 18
    },
    {
      "val": "2015-01-01 13:00:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.la_transaction_au_code_postal_a_lheure_dans_lhistorique(String,String)"
});
formatter.result({
  "duration": 8328417,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "33142",
      "offset": 20
    },
    {
      "val": "2015-01-01 14:00:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 98407,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_frauduleuse()"
});
formatter.result({
  "duration": 30481,
  "status": "passed"
});
formatter.before({
  "duration": 24641,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Historique avec des codes postaux non reconnus",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;3",
  "type": "scenario",
  "keyword": "Plan du Scénario"
});
formatter.step({
  "line": 29,
  "name": "la transaction au XXX XXX à 2015-01-01 13:15:00 UTC dans l\u0027historique",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 30,
  "name": "je fais un achat au 33142 à 2015-01-01 14:00:00 UTC",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est considérée comme frauduleuse",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "XXX XXX",
      "offset": 18
    },
    {
      "val": "2015-01-01 13:15:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.la_transaction_au_code_postal_a_lheure_dans_lhistorique(String,String)"
});
formatter.result({
  "duration": 6012842,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "33142",
      "offset": 20
    },
    {
      "val": "2015-01-01 14:00:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 112888,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_frauduleuse()"
});
formatter.result({
  "duration": 14938,
  "status": "passed"
});
formatter.before({
  "duration": 20418,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Historique avec des codes postaux non reconnus",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;historique-avec-des-codes-postaux-non-reconnus;;4",
  "type": "scenario",
  "keyword": "Plan du Scénario"
});
formatter.step({
  "line": 29,
  "name": "la transaction au XXX XXX à 2015-01-01 13:30:00 UTC dans l\u0027historique",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 30,
  "name": "je fais un achat au 33142 à 2015-01-01 14:00:00 UTC",
  "keyword": "Quand "
});
formatter.step({
  "line": 31,
  "name": "la demande est considérée comme frauduleuse",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "XXX XXX",
      "offset": 18
    },
    {
      "val": "2015-01-01 13:30:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.la_transaction_au_code_postal_a_lheure_dans_lhistorique(String,String)"
});
formatter.result({
  "duration": 6992574,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "33142",
      "offset": 20
    },
    {
      "val": "2015-01-01 14:00:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 81139,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_frauduleuse()"
});
formatter.result({
  "duration": 27833,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 39,
  "name": "Détection de la fraude par distance des codes postaux",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux",
  "type": "scenario_outline",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 41,
  "name": "le dernier achat effectué au \u003cdernier_code_postal\u003e à \u003cderniere_heure\u003e",
  "keyword": "Étant donné "
});
formatter.step({
  "comments": [
    {
      "line": 42,
      "value": "#Et une limite de 200 km/h"
    }
  ],
  "line": 43,
  "name": "je fais un achat au \u003ccode_postal_actuel\u003e à \u003cheure_actuelle\u003e",
  "keyword": "Quand "
});
formatter.step({
  "line": 44,
  "name": "la demande est considérée comme \u003cjugement\u003e",
  "keyword": "Alors "
});
formatter.examples({
  "line": 46,
  "name": "",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;",
  "rows": [
    {
      "cells": [
        "dernier_code_postal",
        "derniere_heure",
        "code_postal_actuel",
        "heure_actuelle",
        "jugement"
      ],
      "line": 47,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;1"
    },
    {
      "cells": [
        "G1T 1H5",
        "2015-01-01 20:00:00 UTC",
        "G1T 1C4",
        "2015-01-01 20:32:34 UTC",
        "Non Frauduleuse"
      ],
      "line": 48,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;2"
    },
    {
      "cells": [
        "G1T 1H5",
        "2015-01-01 20:00:00 UTC",
        "33142",
        "2015-01-01 22:00:00 UTC",
        "Frauduleuse"
      ],
      "line": 49,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;3"
    },
    {
      "cells": [
        "G1T 1H5",
        "2015-01-01 20:00:00 UTC",
        "33142",
        "2015-01-02 05:00:00 UTC",
        "Frauduleuse"
      ],
      "line": 50,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;4"
    },
    {
      "cells": [
        "G1T 1H5",
        "2015-01-01 20:00:00 UTC",
        "H7M 1Y7",
        "2015-01-02 21:40:00 UTC",
        "Non Frauduleuse"
      ],
      "line": 51,
      "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;5"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 38431,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "Détection de la fraude par distance des codes postaux",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;2",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 41,
  "name": "le dernier achat effectué au G1T 1H5 à 2015-01-01 20:00:00 UTC",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "comments": [
    {
      "line": 42,
      "value": "#Et une limite de 200 km/h"
    }
  ],
  "line": 43,
  "name": "je fais un achat au G1T 1C4 à 2015-01-01 20:32:34 UTC",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "Quand "
});
formatter.step({
  "line": 44,
  "name": "la demande est considérée comme Non Frauduleuse",
  "matchedColumns": [
    4
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "G1T 1H5",
      "offset": 29
    },
    {
      "val": "2015-01-01 20:00:00 UTC",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.le_dernier_achat_effectue_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 7320361,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "G1T 1C4",
      "offset": 20
    },
    {
      "val": "2015-01-01 20:32:34 UTC",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 70003,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_Non_Frauduleuse()"
});
formatter.result({
  "duration": 10390,
  "status": "passed"
});
formatter.before({
  "duration": 15097,
  "status": "passed"
});
formatter.scenario({
  "line": 49,
  "name": "Détection de la fraude par distance des codes postaux",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;3",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 41,
  "name": "le dernier achat effectué au G1T 1H5 à 2015-01-01 20:00:00 UTC",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "comments": [
    {
      "line": 42,
      "value": "#Et une limite de 200 km/h"
    }
  ],
  "line": 43,
  "name": "je fais un achat au 33142 à 2015-01-01 22:00:00 UTC",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "Quand "
});
formatter.step({
  "line": 44,
  "name": "la demande est considérée comme Frauduleuse",
  "matchedColumns": [
    4
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "G1T 1H5",
      "offset": 29
    },
    {
      "val": "2015-01-01 20:00:00 UTC",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.le_dernier_achat_effectue_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 6438933,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "33142",
      "offset": 20
    },
    {
      "val": "2015-01-01 22:00:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 76705,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_Frauduleuse()"
});
formatter.result({
  "duration": 28875,
  "status": "passed"
});
formatter.before({
  "duration": 22156,
  "status": "passed"
});
formatter.scenario({
  "line": 50,
  "name": "Détection de la fraude par distance des codes postaux",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;4",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 41,
  "name": "le dernier achat effectué au G1T 1H5 à 2015-01-01 20:00:00 UTC",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "comments": [
    {
      "line": 42,
      "value": "#Et une limite de 200 km/h"
    }
  ],
  "line": 43,
  "name": "je fais un achat au 33142 à 2015-01-02 05:00:00 UTC",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "Quand "
});
formatter.step({
  "line": 44,
  "name": "la demande est considérée comme Frauduleuse",
  "matchedColumns": [
    4
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "G1T 1H5",
      "offset": 29
    },
    {
      "val": "2015-01-01 20:00:00 UTC",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.le_dernier_achat_effectue_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 7064025,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "33142",
      "offset": 20
    },
    {
      "val": "2015-01-02 05:00:00 UTC",
      "offset": 28
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 90482,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_Frauduleuse()"
});
formatter.result({
  "duration": 17195,
  "status": "passed"
});
formatter.before({
  "duration": 32816,
  "status": "passed"
});
formatter.scenario({
  "line": 51,
  "name": "Détection de la fraude par distance des codes postaux",
  "description": "",
  "id": "détection-automatique-de-la-fraude-par-la-distance-en-km;détection-de-la-fraude-par-distance-des-codes-postaux;;5",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 41,
  "name": "le dernier achat effectué au G1T 1H5 à 2015-01-01 20:00:00 UTC",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "comments": [
    {
      "line": 42,
      "value": "#Et une limite de 200 km/h"
    }
  ],
  "line": 43,
  "name": "je fais un achat au H7M 1Y7 à 2015-01-02 21:40:00 UTC",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "Quand "
});
formatter.step({
  "line": 44,
  "name": "la demande est considérée comme Non Frauduleuse",
  "matchedColumns": [
    4
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "G1T 1H5",
      "offset": 29
    },
    {
      "val": "2015-01-01 20:00:00 UTC",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.le_dernier_achat_effectue_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 7061278,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "H7M 1Y7",
      "offset": 20
    },
    {
      "val": "2015-01-02 21:40:00 UTC",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.je_fais_un_achat_au_code_postal_a_lheure(String,String)"
});
formatter.result({
  "duration": 60069,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_consideree_comme_Non_Frauduleuse()"
});
formatter.result({
  "duration": 11418,
  "status": "passed"
});
formatter.uri("traitement-achat.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: fr"
    }
  ],
  "line": 2,
  "name": "Traiter les demandes électroniques d\u0027achat",
  "description": "Afin de pouvoir accepter les cartes de crédit dans mon commerce\nEn tant que marchand\nJe veux avoir un système permettant de traiter électroniquement les demandes d\u0027achats",
  "id": "traiter-les-demandes-électroniques-d\u0027achat",
  "keyword": "Fonctionnalité"
});
formatter.before({
  "duration": 22359,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Demande acceptée",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demande-acceptée",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 8,
  "name": "une demande valide",
  "keyword": "Etant donné "
});
formatter.step({
  "line": 9,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 10,
  "name": "la demande est autorisée",
  "keyword": "Alors "
});
formatter.step({
  "line": 11,
  "name": "un relevé est produit",
  "keyword": "Et "
});
formatter.step({
  "line": 12,
  "name": "la transaction est conservée au compte",
  "keyword": "Et "
});
formatter.step({
  "line": 13,
  "name": "le statut de la transaction est ATTENTE",
  "keyword": "Et "
});
formatter.step({
  "line": 14,
  "name": "la demande est archivée",
  "keyword": "Et "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 6935211,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 51083687,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_autorisee()"
});
formatter.result({
  "duration": 11772172,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.un_releve_est_produit()"
});
formatter.result({
  "duration": 14782628,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_transaction_est_conservee_au_compte()"
});
formatter.result({
  "duration": 13976856,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ATTENTE",
      "offset": 32
    }
  ],
  "location": "TransactionRequestContext.le_statut_de_transaction_est(String)"
});
formatter.result({
  "duration": 1012180,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_archivee()"
});
formatter.result({
  "duration": 6418713,
  "status": "passed"
});
formatter.before({
  "duration": 22244,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Production d\u0027un relevé pour une demande acceptée",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;production-d\u0027un-relevé-pour-une-demande-acceptée",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 17,
  "name": "une demande traitée",
  "keyword": "Etant donné "
});
formatter.step({
  "line": 18,
  "name": "la demande a été autorisée",
  "keyword": "Et "
});
formatter.step({
  "line": 19,
  "name": "un relevé est produit suite à la demande",
  "keyword": "Quand "
});
formatter.step({
  "line": 20,
  "name": "le relevé indique l\u0027autorisation",
  "keyword": "Alors "
});
formatter.step({
  "line": 21,
  "name": "le numéro de la transaction",
  "keyword": "Et "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_traitee()"
});
formatter.result({
  "duration": 60831005,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_a_ete_autorisee()"
});
formatter.result({
  "duration": 10880572,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.un_releve_est_produit_suite_a_la_demande()"
});
formatter.result({
  "duration": 133837,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_releve_indique_l_autorisation()"
});
formatter.result({
  "duration": 163876,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_numero_de_la_transaction()"
});
formatter.result({
  "duration": 173598,
  "status": "passed"
});
formatter.before({
  "duration": 22918,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Traitement des demandes erronées",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;traitement-des-demandes-erronées",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 24,
  "name": "une demande invalide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 25,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 26,
  "name": "la demande est archivée",
  "keyword": "Alors "
});
formatter.step({
  "line": 27,
  "name": "aucune transaction n\u0027est générée",
  "keyword": "Et "
});
formatter.step({
  "line": 28,
  "name": "aucun relevé n\u0027est produit",
  "keyword": "Et "
});
formatter.step({
  "line": 29,
  "name": "le marchand est notifié de l\u0027erreur",
  "keyword": "Et "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_invalide()"
});
formatter.result({
  "duration": 7395671,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 19178145,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_archivee()"
});
formatter.result({
  "duration": 719516,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.aucune_transaction_n_est_générée()"
});
formatter.result({
  "duration": 13694490,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.aucun_releve_est_produit()"
});
formatter.result({
  "duration": 12050111,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_marchand_est_notifie_de_l_erreur()"
});
formatter.result({
  "duration": 406112,
  "status": "passed"
});
formatter.before({
  "duration": 20817,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Demandes avec le montant manquant",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-le-montant-manquant",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 32,
  "name": "une demande d\u0027achat sans montant",
  "keyword": "Étant donnée "
});
formatter.step({
  "line": 33,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 34,
  "name": "la demande est erronée par le montant",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_d_achat_sans_montant()"
});
formatter.result({
  "duration": 4645616,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 19039875,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_le_montant()"
});
formatter.result({
  "duration": 10536627,
  "status": "passed"
});
formatter.before({
  "duration": 19257,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Demandes avec un montant inférieur à 1 cent",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-montant-inférieur-à-1-cent",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 37,
  "name": "une demande d\u0027achat avec un montant de 0.009",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 38,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 39,
  "name": "la demande est erronée par le montant",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "0.009",
      "offset": 39
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_un_montant_de_(float)"
});
formatter.result({
  "duration": 4235186,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 13536697,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_le_montant()"
});
formatter.result({
  "duration": 8486383,
  "status": "passed"
});
formatter.before({
  "duration": 16633,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Demandes avec le numéro de carte de crédit manquant",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-le-numéro-de-carte-de-crédit-manquant",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 42,
  "name": "une demande d\u0027achat sans numéro de carte de crédit",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 43,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 44,
  "name": "la demande est erronée par la carte de crédit",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_d_achat_sans_numero_de_carte_de_credit()"
});
formatter.result({
  "duration": 5039216,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 12801065,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 8979307,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 46,
  "name": "Demandes avec un numéro de carte de crédit de moins de 9 chiffres",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres",
  "type": "scenario_outline",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 47,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit \u003cnumero\u003e",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 48,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 49,
  "name": "la demande est \u003cresultat\u003e",
  "keyword": "Alors "
});
formatter.examples({
  "line": 51,
  "name": "",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;",
  "rows": [
    {
      "cells": [
        "numero",
        "resultat"
      ],
      "line": 52,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;1"
    },
    {
      "cells": [
        "1 2 3 4 5 6 7 8",
        "erronée par la carte de crédit"
      ],
      "line": 53,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;2"
    },
    {
      "cells": [
        "1 2 3 4 5 6 7 8 9",
        "valide"
      ],
      "line": 54,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;3"
    },
    {
      "cells": [
        "123456789",
        "valide"
      ],
      "line": 55,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;4"
    },
    {
      "cells": [
        "1 2 3 4 5 6 7 8 9 0",
        "valide"
      ],
      "line": 56,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;5"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 22486,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "Demandes avec un numéro de carte de crédit de moins de 9 chiffres",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;2",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 47,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit 1 2 3 4 5 6 7 8",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 48,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 49,
  "name": "la demande est erronée par la carte de crédit",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "1 2 3 4 5 6 7 8",
      "offset": 54
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String)"
});
formatter.result({
  "duration": 6535073,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 16349928,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 10654554,
  "status": "passed"
});
formatter.before({
  "duration": 24256,
  "status": "passed"
});
formatter.scenario({
  "line": 54,
  "name": "Demandes avec un numéro de carte de crédit de moins de 9 chiffres",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;3",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 47,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit 1 2 3 4 5 6 7 8 9",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 48,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 49,
  "name": "la demande est valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "1 2 3 4 5 6 7 8 9",
      "offset": 54
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String)"
});
formatter.result({
  "duration": 5123349,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 20226976,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_valide()"
});
formatter.result({
  "duration": 8935176,
  "status": "passed"
});
formatter.before({
  "duration": 14716,
  "status": "passed"
});
formatter.scenario({
  "line": 55,
  "name": "Demandes avec un numéro de carte de crédit de moins de 9 chiffres",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;4",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 47,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit 123456789",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 48,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 49,
  "name": "la demande est valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "123456789",
      "offset": 54
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String)"
});
formatter.result({
  "duration": 5694366,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 18050301,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_valide()"
});
formatter.result({
  "duration": 9376289,
  "status": "passed"
});
formatter.before({
  "duration": 17690,
  "status": "passed"
});
formatter.scenario({
  "line": 56,
  "name": "Demandes avec un numéro de carte de crédit de moins de 9 chiffres",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-de-moins-de-9-chiffres;;5",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 47,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit 1 2 3 4 5 6 7 8 9 0",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 48,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 49,
  "name": "la demande est valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "1 2 3 4 5 6 7 8 9 0",
      "offset": 54
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String)"
});
formatter.result({
  "duration": 5625280,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 16389602,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_valide()"
});
formatter.result({
  "duration": 9917493,
  "status": "passed"
});
formatter.before({
  "duration": 22389,
  "status": "passed"
});
formatter.scenario({
  "line": 58,
  "name": "Demandes avec un numéro de carte de crédit qui contient des caractères non-numériques",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-qui-contient-des-caractères-non-numériques",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 59,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit \"12x345678910\"",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 60,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 61,
  "name": "la demande est erronée par la carte de crédit",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "\"12x345678910\"",
      "offset": 54
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String)"
});
formatter.result({
  "duration": 6369796,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 16899543,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 10709999,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 63,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration",
  "type": "scenario_outline",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration \u003cdate_exp_envoyee\u003e",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est \u003cresultat\u003e",
  "keyword": "Alors "
});
formatter.examples({
  "line": 68,
  "name": "",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;",
  "rows": [
    {
      "cells": [
        "date_exp_envoyee",
        "resultat"
      ],
      "line": 69,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;1"
    },
    {
      "cells": [
        "01/02",
        "valide"
      ],
      "line": 70,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;2"
    },
    {
      "cells": [
        "1/2",
        "valide"
      ],
      "line": 71,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;3"
    },
    {
      "cells": [
        "0102",
        "erronée par la carte de crédit"
      ],
      "line": 72,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;4"
    },
    {
      "cells": [
        "01-02",
        "erronée par la carte de crédit"
      ],
      "line": 73,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;5"
    },
    {
      "cells": [
        "2015/01/02",
        "erronée par la carte de crédit"
      ],
      "line": 74,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;6"
    },
    {
      "cells": [
        "32/15",
        "erronée par la carte de crédit"
      ],
      "line": 75,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;7"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 22451,
  "status": "passed"
});
formatter.scenario({
  "line": 70,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;2",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration 01/02",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "01/02",
      "offset": 38
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration(String)"
});
formatter.result({
  "duration": 5010830,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 46544151,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_valide()"
});
formatter.result({
  "duration": 8012667,
  "status": "passed"
});
formatter.before({
  "duration": 13866,
  "status": "passed"
});
formatter.scenario({
  "line": 71,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;3",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration 1/2",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "1/2",
      "offset": 38
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration(String)"
});
formatter.result({
  "duration": 4974288,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 54945492,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_valide()"
});
formatter.result({
  "duration": 11804879,
  "status": "passed"
});
formatter.before({
  "duration": 21018,
  "status": "passed"
});
formatter.scenario({
  "line": 72,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;4",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration 0102",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est erronée par la carte de crédit",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "0102",
      "offset": 38
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration(String)"
});
formatter.result({
  "duration": 5603838,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 18426314,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 14862807,
  "status": "passed"
});
formatter.before({
  "duration": 18769,
  "status": "passed"
});
formatter.scenario({
  "line": 73,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;5",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration 01-02",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est erronée par la carte de crédit",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "01-02",
      "offset": 38
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration(String)"
});
formatter.result({
  "duration": 5207179,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 21925646,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 9839003,
  "status": "passed"
});
formatter.before({
  "duration": 23410,
  "status": "passed"
});
formatter.scenario({
  "line": 74,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;6",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration 2015/01/02",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est erronée par la carte de crédit",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "2015/01/02",
      "offset": 38
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration(String)"
});
formatter.result({
  "duration": 5578944,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 16919714,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 9162081,
  "status": "passed"
});
formatter.before({
  "duration": 20190,
  "status": "passed"
});
formatter.scenario({
  "line": 75,
  "name": "Vérification du format de la date d\u0027expiration",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;vérification-du-format-de-la-date-d\u0027expiration;;7",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 64,
  "name": "une demande avec la date d\u0027expiration 32/15",
  "matchedColumns": [
    0
  ],
  "keyword": "Étant donné "
});
formatter.step({
  "line": 65,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 66,
  "name": "la demande est erronée par la carte de crédit",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "32/15",
      "offset": 38
    }
  ],
  "location": "TransactionRequestContext.une_demande_avec_la_date_d_expiration(String)"
});
formatter.result({
  "duration": 4732499,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 17396196,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_erronee_par_la_carte_de_crédit()"
});
formatter.result({
  "duration": 19151727,
  "status": "passed"
});
formatter.before({
  "duration": 32781,
  "status": "passed"
});
formatter.scenario({
  "line": 77,
  "name": "Demandes avec un numéro de carte de crédit avec des espaces",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demandes-avec-un-numéro-de-carte-de-crédit-avec-des-espaces",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 78,
  "name": "une demande d\u0027achat avec le numéro de carte de crédit 1 2 3 4 5 6 7 8 9",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 79,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 80,
  "name": "la demande est valide",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "1 2 3 4 5 6 7 8 9",
      "offset": 54
    }
  ],
  "location": "TransactionRequestContext.une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String)"
});
formatter.result({
  "duration": 5388953,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 17185129,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_valide()"
});
formatter.result({
  "duration": 9113161,
  "status": "passed"
});
formatter.before({
  "duration": 39227,
  "status": "passed"
});
formatter.scenario({
  "line": 82,
  "name": "Traitement des demandes refusées",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;traitement-des-demandes-refusées",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 83,
  "name": "une demande d\u0027achat est refusée",
  "keyword": "Quand "
});
formatter.step({
  "line": 84,
  "name": "la demande est archivée",
  "keyword": "Alors "
});
formatter.step({
  "line": 85,
  "name": "aucune transaction n\u0027est générée",
  "keyword": "Et "
});
formatter.step({
  "line": 86,
  "name": "un relevé est produit",
  "keyword": "Et "
});
formatter.step({
  "line": 87,
  "name": "la demande est archivée",
  "keyword": "Et "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_d_achat_est_refusee()"
});
formatter.result({
  "duration": 19843465,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_archivee()"
});
formatter.result({
  "duration": 830468,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.aucune_transaction_n_est_générée()"
});
formatter.result({
  "duration": 9006191,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.un_releve_est_produit()"
});
formatter.result({
  "duration": 8158620,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_archivee()"
});
formatter.result({
  "duration": 492225,
  "status": "passed"
});
formatter.before({
  "duration": 17702,
  "status": "passed"
});
formatter.scenario({
  "line": 89,
  "name": "Production d\u0027un relevé pour une demande refusée",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;production-d\u0027un-relevé-pour-une-demande-refusée",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 90,
  "name": "une demande d\u0027achat est refusée",
  "keyword": "Quand "
});
formatter.step({
  "line": 91,
  "name": "la demande est refusée",
  "keyword": "Alors "
});
formatter.step({
  "line": 92,
  "name": "aucune raison n\u0027est donnée",
  "keyword": "Et "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_d_achat_est_refusee()"
});
formatter.result({
  "duration": 18995644,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refusee()"
});
formatter.result({
  "duration": 6559632,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.aucune_raison_n_est_donnée()"
});
formatter.result({
  "duration": 14037088,
  "status": "passed"
});
formatter.before({
  "duration": 13626,
  "status": "passed"
});
formatter.scenario({
  "line": 94,
  "name": "Identification d\u0027une carte VISA par le numéro de carte",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;identification-d\u0027une-carte-visa-par-le-numéro-de-carte",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 95,
  "name": "un numéro de carte débutant par un \u00274\u0027",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 96,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 97,
  "name": "c\u0027est une carte VISA",
  "keyword": "Alors "
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 36
    }
  ],
  "location": "TransactionRequestContext.un_numéro_de_carte_débutant_par_un_(int)"
});
formatter.result({
  "duration": 2789318,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 43186678,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.c_est_une_carte_VISA()"
});
formatter.result({
  "duration": 1602414,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 99,
  "name": "Nombre de chiffres pour un numéro de carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa",
  "type": "scenario_outline",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 100,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 101,
  "name": "une carte de crédit VISA avec \u003cdigits\u003e chiffres",
  "keyword": "Et "
});
formatter.step({
  "line": 102,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 103,
  "name": "la demande est considérée \u003cresultat\u003e",
  "keyword": "Alors "
});
formatter.examples({
  "line": 105,
  "name": "",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;",
  "rows": [
    {
      "cells": [
        "digits",
        "resultat"
      ],
      "line": 106,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;1"
    },
    {
      "cells": [
        "12",
        "erronée"
      ],
      "line": 107,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;2"
    },
    {
      "cells": [
        "13",
        "valide"
      ],
      "line": 108,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;3"
    },
    {
      "cells": [
        "14",
        "erronée"
      ],
      "line": 109,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;4"
    },
    {
      "cells": [
        "16",
        "valide"
      ],
      "line": 110,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;5"
    },
    {
      "cells": [
        "17",
        "erronée"
      ],
      "line": 111,
      "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;6"
    }
  ],
  "keyword": "Exemples"
});
formatter.before({
  "duration": 22474,
  "status": "passed"
});
formatter.scenario({
  "line": 107,
  "name": "Nombre de chiffres pour un numéro de carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;2",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 100,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 101,
  "name": "une carte de crédit VISA avec 12 chiffres",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 102,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 103,
  "name": "la demande est considérée erronée",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 2913104,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_VISA_avec_digits_chiffres(int)"
});
formatter.result({
  "duration": 130697,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 15595332,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_considérée_erronée()"
});
formatter.result({
  "duration": 9899602,
  "status": "passed"
});
formatter.before({
  "duration": 62731,
  "status": "passed"
});
formatter.scenario({
  "line": 108,
  "name": "Nombre de chiffres pour un numéro de carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;3",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 100,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 101,
  "name": "une carte de crédit VISA avec 13 chiffres",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 102,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 103,
  "name": "la demande est considérée valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 5855408,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "13",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_VISA_avec_digits_chiffres(int)"
});
formatter.result({
  "duration": 147919,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 18164846,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_considérée_valide()"
});
formatter.result({
  "duration": 11018125,
  "status": "passed"
});
formatter.before({
  "duration": 14157,
  "status": "passed"
});
formatter.scenario({
  "line": 109,
  "name": "Nombre de chiffres pour un numéro de carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;4",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 100,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 101,
  "name": "une carte de crédit VISA avec 14 chiffres",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 102,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 103,
  "name": "la demande est considérée erronée",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 2783462,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "14",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_VISA_avec_digits_chiffres(int)"
});
formatter.result({
  "duration": 117595,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 13326043,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_considérée_erronée()"
});
formatter.result({
  "duration": 12091983,
  "status": "passed"
});
formatter.before({
  "duration": 20211,
  "status": "passed"
});
formatter.scenario({
  "line": 110,
  "name": "Nombre de chiffres pour un numéro de carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;5",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 100,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 101,
  "name": "une carte de crédit VISA avec 16 chiffres",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 102,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 103,
  "name": "la demande est considérée valide",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 4092122,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "16",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_VISA_avec_digits_chiffres(int)"
});
formatter.result({
  "duration": 103801,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 15723489,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_considérée_valide()"
});
formatter.result({
  "duration": 10118296,
  "status": "passed"
});
formatter.before({
  "duration": 18455,
  "status": "passed"
});
formatter.scenario({
  "line": 111,
  "name": "Nombre de chiffres pour un numéro de carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;nombre-de-chiffres-pour-un-numéro-de-carte-visa;;6",
  "type": "scenario",
  "keyword": "Plan du scénario"
});
formatter.step({
  "line": 100,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 101,
  "name": "une carte de crédit VISA avec 17 chiffres",
  "matchedColumns": [
    0
  ],
  "keyword": "Et "
});
formatter.step({
  "line": 102,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 103,
  "name": "la demande est considérée erronée",
  "matchedColumns": [
    1
  ],
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 3933945,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "17",
      "offset": 30
    }
  ],
  "location": "TransactionRequestContext.une_carte_de_crédit_VISA_avec_digits_chiffres(int)"
});
formatter.result({
  "duration": 95908,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 17353440,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_considérée_erronée()"
});
formatter.result({
  "duration": 8215644,
  "status": "passed"
});
formatter.before({
  "duration": 17647,
  "status": "passed"
});
formatter.scenario({
  "line": 113,
  "name": "Validation du Checksum pour une carte VISA",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;validation-du-checksum-pour-une-carte-visa",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 114,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 115,
  "name": "une carte de crédit VISA avec un checksum invalide",
  "keyword": "Et "
});
formatter.step({
  "line": 116,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 117,
  "name": "la demande est considérée erronée",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 17404547,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.une_carte_de_crédit_VISA_avec_un_checksum_invalide()"
});
formatter.result({
  "duration": 33189,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 20056769,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_considérée_erronée()"
});
formatter.result({
  "duration": 11847533,
  "status": "passed"
});
formatter.before({
  "duration": 18321,
  "status": "passed"
});
formatter.scenario({
  "line": 119,
  "name": "Demande avec un montant accepté",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demande-avec-un-montant-accepté",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 120,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 121,
  "name": "le montant est accepté",
  "keyword": "Et "
});
formatter.step({
  "line": 122,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 123,
  "name": "le solde du compte est modifié",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 4446494,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_montant_est_accepte()"
});
formatter.result({
  "duration": 3629698,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 45191461,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_solde_du_compte_est_modifie()"
});
formatter.result({
  "duration": 3488606,
  "status": "passed"
});
formatter.before({
  "duration": 25306,
  "status": "passed"
});
formatter.scenario({
  "line": 125,
  "name": "Demande avec un montant excédant le solde",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demande-avec-un-montant-excédant-le-solde",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 126,
  "name": "une demande valide",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 127,
  "name": "le montant n\u0027est pas accepté",
  "keyword": "Et "
});
formatter.step({
  "line": 128,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 129,
  "name": "le solde du compte n\u0027est pas modifié",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 24345414,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_montant_n_est_pas_accepte()"
});
formatter.result({
  "duration": 4950834,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 36742487,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_solde_du_compte_n_est_pas_modifie()"
});
formatter.result({
  "duration": 1138117,
  "status": "passed"
});
formatter.before({
  "duration": 18157,
  "status": "passed"
});
formatter.scenario({
  "line": 131,
  "name": "Conservation du marchand dans la transaction",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;conservation-du-marchand-dans-la-transaction",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 132,
  "name": "une demande valide",
  "keyword": "Etant donné "
});
formatter.step({
  "line": 133,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 134,
  "name": "le marchand est conservé dans la transaction",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide()"
});
formatter.result({
  "duration": 21879232,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 42938959,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.le_marchand_conserve_transaction()"
});
formatter.result({
  "duration": 3094129,
  "status": "passed"
});
formatter.before({
  "duration": 18743,
  "status": "passed"
});
formatter.scenario({
  "line": 136,
  "name": "Demande avec un terminal inexistant",
  "description": "",
  "id": "traiter-les-demandes-électroniques-d\u0027achat;demande-avec-un-terminal-inexistant",
  "type": "scenario",
  "keyword": "Scénario"
});
formatter.step({
  "line": 137,
  "name": "une demande valide et un terminal inexistant",
  "keyword": "Étant donné "
});
formatter.step({
  "line": 138,
  "name": "la demande est traitée",
  "keyword": "Quand "
});
formatter.step({
  "line": 139,
  "name": "la demande est refusée",
  "keyword": "Alors "
});
formatter.match({
  "location": "TransactionRequestContext.une_demande_valide_terminal_inexistant()"
});
formatter.result({
  "duration": 3682840,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_traitee()"
});
formatter.result({
  "duration": 17157056,
  "status": "passed"
});
formatter.match({
  "location": "TransactionRequestContext.la_demande_est_refusee()"
});
formatter.result({
  "duration": 15595207,
  "status": "passed"
});
});