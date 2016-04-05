#language: fr
Fonctionnalité: Confirmation par le marchand
  Afin d'être payé
  En tant que marchand
  Je peux confirmer les transactions passées avec le montant final

  Scénario: Soumission de transactions admissibles
    Étant donné un marchand avec des transactions admissibles en attente
    Quand il soumet les transactions
    Alors les transactions sont confirmées

  Scénario: Soumission de transactions par un marchand n'ayant aucune transaction à son effectif
    Étant donné un marchand sans transaction
    Quand il soumet aucune transaction
    Alors rien n'est effectué
    Et aucune erreur n’est reportée

  Scénario: Soumission d'une transaction déjà confirmée
    Étant donné une transaction déjà confirmée
    Quand le marchand soumet cette transaction
    Alors la transaction reste dans son statut actuel

  Scénario: Soumission de transactions ayant une transaction inadmissible
    Étant donné un marchand avec des transactions admissibles
    Et ayant des transactions inadmissible
    Quand il soumet les transactions inadmissibles
    Alors aucune transaction n’est confirmée
    Et la requête est rejetée

  Scénario: Soumission de transactions par un marchand inexistant
    Étant donné un numéro de marchand inexistant
    Quand le marchand inexistant soumet une liste de transaction
    Alors la resource est donc introuvable

  Scénario: Soumission de transactions inexistantes
    Étant donné des transactions inexistante
    Quand le marchand soumet ces transactions inexistantes
    Alors une erreur se produit