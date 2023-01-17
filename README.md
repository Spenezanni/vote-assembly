# voteAssembly
Projeto Vote Assembly
Projeto Vote Assembly

Esse projeto consiste em cadastrar e enviar no formato JSON um tópico (pauta) que possibilita uma assembleia votar em um tema em um tempo previamente estipulado.
Cada membro da assembleia tem direito a um voto, para isso sua identificação é validada antes da concretização do voto relacionado a um tópico.

Tecnologias

Todas as versões estão definidas no POM do projeto, para o subir o projeto é necessário de Java >= 11.
Configuração de um Banco de dados no application.yml, as entidades do projeto estão mapeadas com JPA (Java Persistence API).
Configuração do Apache kafka (Mensageria) https://developer.confluent.io/
Utilizar o Docker para subir o Kafka e a ferramenta Kafkadrop
image

Instanciar um tópico no Serviço do Kafka.
image

Java 11
Apache Kafka
Spring Boot
Lombok
JPA
Postgres
image
