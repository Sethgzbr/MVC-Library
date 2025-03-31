# MVC-Library

![image](https://github.com/user-attachments/assets/964f2862-1f4f-481a-a9a6-a1a4e9500b07)

![image](https://github.com/user-attachments/assets/a6a30f2f-d64c-4bb0-a5ac-ede1d955ec67)

Per què al servei estem utilitzant mètodes que no hem declarat explícitament al repositori? Com és possible?


El repositori pot elegir fer l’extends de les interfícies PagingAndSortingRepository o de JpaRepository. En què es diferencien aquestes dues amb la interfície CrudRepository?
Spring Data JPA crea automàticament una implementació dels mètodes a partir de les interfícies com JpaRepository o CrudRepository.
Diferència entre PagingAndSortingRepository, JpaRepository i CrudRepository:
CrudRepository: Mètodes bàsics per CRUD.
JpaRepository: Extens CrudRepository amb funcionalitats addicionals (com paginació i ordenació).
PagingAndSortingRepository: Extens CrudRepository amb suport per paginació i ordenació.

Què significa Optional<Classe> i per a què serveix?
Optional fa que pugui ser null i no permet l'error NullPointerException.

Per què el controlador utilitza el servei i no la seva implementació? 
El servei és una capa d'abstracció que encapsula la lògica de negoci. El controlador interactua amb el servei per mantenir una separació de responsabilitats i facilitar el manteniment.
