#language: fr
Fonctionnalité: Analyser en fonction du compte client
  Afin d'éviter la fraude et le dépasser des capacité de paiement
  En tant que compagnie de carte de crédit
  Je veux effectuer des vérification sur le compte client

  Scénario: Demandes avec un numéro de carte de crédit inexistant
    Étant donné une demande valide
    Et un numéro de carte associé à aucun compte
    Quand la demande est traitée
    Alors la demande est refusée

  Plan du scénario: Demandes avec une carte expirée
    Étant donné que la date d'aujourd'hui est le 02/15
    Et une demande avec une date d'expiration <date_exp> pour la carte
    Quand la demande est traitée
    Alors la demande est <jugement>

    Exemples:
      | date_exp | jugement |
      | 01/14    | refusé   |
      | 01/15    | refusé   |
      | 02/15    | ok       |
      | 03/15    | ok       |

  Plan du scénario: Demandes avec un montant excédant le solde
    Étant donné une demande valide
    Et une carte de crédit associée à un compte avec une limite de crédit de 1200
    Et un montant demandé de <montant>
    Quand la demande est traitée
    Alors la demande est <jugement>

    Exemples:
      | montant | jugement |
      | 1000    | ok       |
      | 1200    | ok       |
      | 2000    | refusé   |