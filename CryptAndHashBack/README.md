# CryptAndHash - Logiciel de Cryptage et Hashage

ENCRYPTAGE/DECRYPTAGE DE FICHIER RSA EN COURS DE DEVELOPPEMENT => 90%

FONCTIONNALITES AWS EN COURS DE DEVELOPPEMENT => 80%

GUI EN COURS DE DEVELOPPEMENT => 5%

## Description

Ce logiciel s'appelle CryptAndHash et possède plusieurs fonctionnalités telles que :
* Amazon Web Services Elastic Compute Cloud (EC2) et Simple Storage Service (S3)
* Cryptage de fichier AES ou RSA
* Hashage de chaînes de caractères.

```
EXEMPLE : Le mot "Test" dans tous les types de hashage proposé donne :

MD2 : 1178f3ddf625018179a93c1a0298dfa9

MD5 : 0cbc6611f5540bd0809a388dc95a615b

SHA128 : 640ab2bae07bedc4c163f679a746f7ab7fb5d1fa

SHA256 : 532eaabd9574880dbf76b9b8cc00832c20a6ec113d682299550d7a6e0f345e25

SHA384 : 7b8f4654076b80eb963911f19cfad1aaf4285ed48e826f6cde1b01a79aa73fadb5446e667fc4f90417782c91270540f3

SHA512 : c6ee9e33cf5c6715a1d148fd73f7318884b41adcb916021e2bc0e800a5c5dd97f5142178f6ae88c8fdd98e1afb0ce4c8d2c54b5f37b30b7da1997bb33b0b8a31

```

Parfait pour crypter ses fichiers et les envoyer sur des machines virtuelles dans le cloud ou pour générer des mots de passe très difficile à casser avec un simple mot ou suite que vous avez déjà en mémoire.

## Pré-requis

```
Version EXE n'a besoin de rien mais la version JAR nécéssite une machine virtuelle java au minimum pour fonctionner, je vous recommande JRE/JDK 8
```

## Installation

Aucune installation pour l'instant n'est nécessaire seulement l'execution de l'EXE ou du JAR.


## Tests

Pour les développeurs, vous pouvez lancer une batterie de tests Junit programmés par mes soins en cas de problème.

Vous pouvez tester ce logiciel en executant seulement CryptAndHash.exe sur votre Windows directement, si vous avez un doute sur le logiciel je vous invite à consulter et analyser son code directement ici.

Si la version Executable Windows ne marche pas, utiliser le .jar dans le dossier target.

PS : Evitez le Message Digest 2 ou 5 si vous cherchez de la grosse sécurité mais taper plus sur du SHA3 ou SHA5.


## Outils

* [Apache Commons Codec](https://commons.apache.org/) - Composant Java
* [AWS SDK](https://aws.amazon.com/fr/sdk-for-java/) - Kit de développement Amazon Web Services
* [Maven](https://maven.apache.org/) - Gestion de projet et de dépendances
* [JUnit](https://junit.org/junit4/) - Framework de développement et d'execution de tests unitaires
* [Launch4J](http://launch4j.sourceforge.net/) - Outil de transformation de JAR en executable Windows.
* [CodeFactor](https://www.codefactor.io/repository/github/xhackax47/cryptandhash) - Analyseur de code.

## Versioning

Git. 

## Auteurs

* **Samy CHAABI** - *Developer* - [Hacka47](https://github.com/xhackax47)
