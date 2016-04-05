#language: fr
Fonctionnalité: Traiter les demandes électroniques d'achat
  Afin de pouvoir accepter les cartes de crédit dans mon commerce
  En tant que marchand
  Je veux avoir un système permettant de traiter électroniquement les demandes d'achats

  Scénario: Demande acceptée
    Etant donné une demande valide
    Quand la demande est traitée
    Alors la demande est autorisée
    Et un relevé est produit
    Et la transaction est conservée au compte
    Et le statut de la transaction est ATTENTE
    Et la demande est archivée

  Scénario: Production d'un relevé pour une demande acceptée
    Etant donné une demande traitée
    Et la demande a été autorisée
    Quand un relevé est produit suite à la demande
    Alors le relevé indique l'autorisation
    Et le numéro de la transaction

  Scénario: Traitement des demandes erronées
    Étant donné une demande invalide
    Quand la demande est traitée
    Alors la demande est archivée
    Et aucune transaction n'est générée
    Et aucun relevé n'est produit
    Et le marchand est notifié de l'erreur

  Scénario: Demandes avec le montant manquant
    Étant donnée une demande d'achat sans montant
    Quand la demande est traitée
    Alors la demande est erronée par le montant

  Scénario: Demandes avec un montant inférieur à 1 cent
    Étant donné une demande d'achat avec un montant de 0.009
    Quand la demande est traitée
    Alors la demande est erronée par le montant

  Scénario: Demandes avec le numéro de carte de crédit manquant
    Étant donné une demande d'achat sans numéro de carte de crédit
    Quand la demande est traitée
    Alors la demande est erronée par la carte de crédit

  Plan du scénario: Demandes avec un numéro de carte de crédit de moins de 9 chiffres
    Étant donné une demande d'achat avec le numéro de carte de crédit <numero>
    Quand la demande est traitée
    Alors la demande est <resultat>

    Exemples:
      | numero              | resultat                       |
      | 1 2 3 4 5 6 7 8     | erronée par la carte de crédit |
      | 1 2 3 4 5 6 7 8 9   | valide                         |
      | 123456789           | valide                         |
      | 1 2 3 4 5 6 7 8 9 0 | valide                         |

  Scénario: Demandes avec un numéro de carte de crédit qui contient des caractères non-numériques
    Étant donné une demande d'achat avec le numéro de carte de crédit "12x345678910"
    Quand la demande est traitée
    Alors la demande est erronée par la carte de crédit

  Plan du scénario: Vérification du format de la date d'expiration
    Étant donné une demande avec la date d'expiration <date_exp_envoyee>
    Quand la demande est traitée
    Alors la demande est <resultat>

    Exemples:
      | date_exp_envoyee | resultat                       |
      | 01/02            | valide                         |
      | 1/2              | valide                         |
      | 0102             | erronée par la carte de crédit |
      | 01-02            | erronée par la carte de crédit |
      | 2015/01/02       | erronée par la carte de crédit |
      | 32/15            | erronée par la carte de crédit |

  Scénario: Demandes avec un numéro de carte de crédit avec des espaces
    Étant donné une demande d'achat avec le numéro de carte de crédit 1 2 3 4 5 6 7 8 9
    Quand la demande est traitée
    Alors la demande est valide

  Scénario: Traitement des demandes refusées
    Quand une demande d'achat est refusée
    Alors la demande est archivée
    Et aucune transaction n'est générée
    Et un relevé est produit
    Et la demande est archivée

  Scénario: Production d'un relevé pour une demande refusée
    Quand une demande d'achat est refusée
    Alors la demande est refusée
    Et aucune raison n'est donnée

  Scénario: Identification d'une carte VISA par le numéro de carte
    Étant donné un numéro de carte débutant par un '4'
    Quand la demande est traitée
    Alors c'est une carte VISA

  Plan du scénario: Nombre de chiffres pour un numéro de carte VISA
    Étant donné une demande valide
    Et une carte de crédit VISA avec <digits> chiffres
    Quand la demande est traitée
    Alors la demande est considérée <resultat>

    Exemples:
      | digits | resultat |
      | 12     | erronée  |
      | 13     | valide   |
      | 14     | erronée  |
      | 16     | valide   |
      | 17     | erronée  |

  Scénario: Validation du Checksum pour une carte VISA
    Étant donné une demande valide
    Et une carte de crédit VISA avec un checksum invalide
    Quand la demande est traitée
    Alors la demande est considérée erronée

  Scénario: Demande avec un montant accepté
    Étant donné une demande valide
    Et le montant est accepté
    Quand la demande est traitée
    Alors le solde du compte est modifié

  Scénario: Demande avec un montant excédant le solde
    Étant donné une demande valide
    Et le montant n'est pas accepté
    Quand la demande est traitée
    Alors le solde du compte n'est pas modifié

  Scénario: Conservation du marchand dans la transaction
    Etant donné une demande valide
    Quand la demande est traitée
    Alors le marchand est conservé dans la transaction

  Scénario: Demande avec un terminal inexistant
    Étant donné une demande valide et un terminal inexistant
    Quand la demande est traitée
    Alors la demande est refusée