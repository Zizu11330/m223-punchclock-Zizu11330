# Übungsprojekt: Punch Clock

Punch Clock ist ein Zeiterfassungssystem, welches mit Quarkus entwickelt wird.

## Aufgabe 1.4: IST-Analyse

Die Abgabe zu Modul 223 (26/4867), Block 1, befindet sich unter
[`docs/aufgabe-1.4-ist-analyse.pdf`](docs/aufgabe-1.4-ist-analyse.pdf).
Sie beschreibt den unveraenderten Ausgangsstand mit vier UML-Diagrammen:
Anwendungsfall-, Klassen-, Sequenz- und Deployment-Diagramm.

Die editierbare Quelle ist
[`docs/aufgabe-1.4-ist-analyse.html`](docs/aufgabe-1.4-ist-analyse.html).
Die Diagramme sind als lokale SVG-Grafiken direkt eingebettet; externe
Dienste oder Bibliotheken sind nicht erforderlich. Zum Erzeugen der PDF
die HTML-Datei in Edge oder Chrome oeffnen und mit Papierformat A4,
Skalierung 100 %, ohne Kopf- und Fusszeilen und mit Hintergrundgrafiken
als PDF drucken. Die Quelle definiert sechs Druckseiten.

## Erste Schritte

1. Erstelle eine Kopie (fork) von diesem Projekt.
1. Stelle sicher, dass Docker installiert ist und läuft.
1. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
1. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.
1. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.