/*
 * Curso: Learning Apache Camel with Spring Boot
 * Autor: Eduardo Pereira Ribeiro
 * Aula: 02
 * Data: 12/03/2022  
 * */

/*
 * O que é o Apache Camel? O Camel é um integrador entre serviços/sistemas,
 * que de maneira geral funcionará como um middleware entre uma aplicação/serviço A
 * e uma aplicação/serviço B, passando por ela uma regra qualquer. 
 * */

package com.eduardo.microsservicos.camelmicroservicea.routes.a;

// Importando a classe do Camel
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// Para criar uma rota no Camel, a classe deve sempre extender RouteBuilder, implementando seus métodos
@Component
public class MyFirstTimerRouter extends RouteBuilder{

	// Dentro do método "configure()" é onde será realizado toda configuração de rotas, smepre sobrescrito e com uma excessão
	@Override
	public void configure() throws Exception {
		/*
		 * Toda vez que configuramos uma rota no Camel, precisamos saber 3 coisas: de onde
		 * a informação vem (serviço A), o que acontece com ela (transformação ou processamento)
		 * e para onde a informação será enviada (serviço B)
		 * */
		
		// Este é o método que nos dirá de onde sai a informação. Nesse caso, de um timer
		from("timer:first-timer") // O nome técnico para "de onde a informação sai" é endpoint. Estamos criando aqui um endpoint
		.to("log:first-timer"); // Esse é o método que dirá para onde a informação deve ir
	}
	
}
