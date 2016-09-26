# stringout

Centralizador de strings em um arquivo externo.

Stringout é uma biblioteca que permite externalizar da aplicação qualquer tipo de string (texto) para uma arquivo pré-determinado, facilitando assim a sua posterior busca e também centralizando em um único local determinados textos indesejáveis dentro dos códigos. Abaixo segue alguns exemplo de utilização.
  
	* Comandos SQL, JPQL, *QL,
	* Configurações específicas de uma aplicação.
	* Mensagens exibidas para os usuários. 
	* Mensagens de internacionalização.
	
Pode ser criado um arquivo diferente para cada agrupamento de strings que se deseja.	

### Busca
	
A busca pelas strings é bem simples e permite buscar qualquer dado a partir de um identificador pré-definido. Segue abaixo exemplo de utilização:

```java
StringOut stringout = StringOutManager.getInstance(StringOutType.JSON);

String value = stringout.find("id");
```

### Parâmetros

Parâmetros também podem ser passados no momento da busca para que sejam processados e substituídos dentro da string localizada.
Ex: 

```java
StringOut stringout = StringOutManager.getInstance(StringOutType.JSON);

Map<String, String> replacements = new HashMap<String, String>();
replacements.put("nome", "Diego Pessoa");
			
String value = stringout.find("id", replacements);
``` 

Dentro da String de destino, a sintaxe que deve se seguida para utilização de parâmetros, é como se segue:

```java
Meu nome é :nome
```

Ou seja, sempre que se desejar passar parâmetros, a sintaxe ":" deve ser utilizada antes da palavra que se deseja substituir.


### Tipos de Arquivos Externos

Stringout aceita 3 tipos diferentes de arquivos externos para se poder ler dados.

	* JSON
	* PROPERTY
	* XML (Ainda em implementação)

	




	
