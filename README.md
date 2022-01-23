# Heiskontroll

Dette repoet inneholder kode for et enkelt heissystem. Koden er skrevet i Kotlin.

## Problemstillinger/kvaliteter heissystemet må hensynta 

* Kapasitet til heisen (kg/antall personer)
* Hvor mange etasjer heisen skal kunne gå til  
* Hva skal heisens forflytninger optimaliseres på? 
  * Korteste reisetid for heisen
  * Minst ventetid for passasjerene
  * Annet?
* Hvor lenge dørene skal være åpne
* Hvordan skal koden struktureres
* Må kunne vite hvor heisen befinner seg og hvor den evt. er på vei
* Nødstopp
* Stopp for vedlikehold
* Estimere reisetid for at heisen når den går mellom etasjer 

## Forutsetninger

* 1 heis
* Flere passasjerer
* Passasjeren kan trykke på for å gå til flere etasjer inne i heisen 
* Nødstopp: antar at det ikke er ønskelig at heisen kan gå til andre etasjer når heisen er i denne tilstanden.

## Design

* To typer knapper, disse sender requester til `ElevatorController` som styrer `Elevator`
  * 1: `ElevatorButton` - representerer knappene inne i heisen
  * 2: `FloorButton` - representerer knappene i etasjene
* `ElevatorController` er "hjernen" som tar inn requester fra knappene, og "sorterer" disse før den kaller `Elevator` med beskjed om hvor heisen skal neste gang.
* Sorteringen som `ElevatorControlleren` gjør er nå en enkel `FIFO` sortering. Men jeg har lagt opp til at dette er modulært og kan utvide/teste ut andre sorteringsalgoritmer som treffer bedre på hva vi ønsker å optimalisere heisen på.
* `Elevator` representerer selve heisen og tar i mot kommandoer fra `ElevatorController` for forflytning. Den holder også på sin egen tilstand om den er `GOING_UP`, `GOING_DOWN` etc.
* Jeg har ikke lagd noen simulering av heisen, men har lagd tester for utvikling/verifikasjon av at ting fungerer. Se testklassene.



## Forbedringer som kan gjøres

- [ ] Forbedre sorteringsalgoritmen for hvilken rekkefølge requestene skal utføres på
- [ ] Feilhåndtering
- [ ] Implementere singleton pattern for `ElevatorController`
- [ ] Kjøre `scheduleElevator()` som en egen jobb som går regelmessig og i tillegg lytter på eventer?
- [ ] Definere interfaces?
