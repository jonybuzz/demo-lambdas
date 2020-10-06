## Demo de Streams y lambdas

Refactorizar la lógica de los métodos de Turnero.java para que usen streams.

Branches:
- master
- ayudin
- solucion

Fuente: https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html

### OPERACIONES INTERMEDIAS
- filter
- map
- flatMap *=> "compacta" listas de listas*
- ordered
- limit

### OPERACIONES FINALES
- collect : list
- forEach : void
- anyMatch : boolean
- allMatch : boolean
- findAny : e
- findFirst : e

### EJEMPLO
```
List<Integer> ids = personas
    .stream()
    .map(p -> p.getId())
    .filter(id -> id > 5)
    .collect(Collectors.toList());
```