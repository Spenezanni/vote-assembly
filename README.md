# voteAssembly
Projeto Vote Assembly

Esse projeto consiste em cadastrar e enviar no formato JSON na Arquitetura REST, um tópico (pauta) que possibilita uma assembleia votar em um tema em um tempo previamente estipulado.
Cada membro da assembleia tem direito a um voto, para isso sua identificação é validada antes da concretização do voto relacionado a um tópico.

Tecnologias

Todas as versões estão definidas no POM do projeto, para o subir o projeto é necessário de Java >= 11.

Configuração de um Banco de dados no application.yml, as entidades do projeto estão mapeadas com JPA (Java Persistence API).

Configuração do Apache kafka (Mensageria) https://developer.confluent.io/

Configurar o Docker para subir o Kafka e a ferramenta Kafkadrop

![image](https://user-images.githubusercontent.com/32372447/212903367-238303af-360a-43c9-b523-bfc35a40f44f.png)

Instanciar um tópico no Serviço do Kafka [Ferramenta Visual Kafdrop].

![image](https://user-images.githubusercontent.com/32372447/212903466-eccff87e-926d-45c7-b085-f2efdbf5f5fc.png)

Outras tecnologias de desenvolvimento; 

Java 11 

Spring Boot (Framework)

Lombok

JPA (Java Persistence API)

Postgres 

![image](https://user-images.githubusercontent.com/32372447/212903512-74cd89e8-02e8-4411-8349-8dd92dd979a6.png)
