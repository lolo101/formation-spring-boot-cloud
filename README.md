# formation-spring-boot-cloud
Exemple de µ-service base sur Spring Boot

## branches
### main
Un service et un client avec un load-balancing statique.

### eureka
Mise en place d'un registre de services Netflix Eureka.

Le registre permet au load-balancer de trouver les services disponibles en fonction du serviceId.

### api-gateway
Mise en place d'une API Gateway qui exploite le registre pour load-balancer les requêtes sur les services.

Permet également d'appliquer des filtres simples sur les requêtes uniquement avec la configuration applicative.

Il est possible d'appliquer des filtres plus complexes en Java.