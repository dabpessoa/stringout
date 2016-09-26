# stringout

Centralizador de strings em um arquivo externo.

Stringout � uma biblioteca que permite externalizar da aplica��o qualquer tipo de string (texto) para uma arquivo pr�-determinado, facilitando assim a sua posterior busca e tamb�m centralizando em um �nico local determinados textos indesej�veis dentro dos c�digos. Abaixo segue alguns exemplo de utiliza��o.
  
	* Comandos SQL, JPQL, *QL,
	* Configura��es espec�ficas de uma aplica��o.
	* Mensagens exibidas para os usu�rios. 
	* Mensagens de internacionaliza��o.
	
Pode ser criado um arquivo diferente para cada agrupamento de strings que se deseja.	

### Busca
	
A busca pelas strings � bem simples e permite buscar qualquer dado a partir de um identificador pr�-definido. Segue abaixo exemplo de utiliza��o:

```java
StringOut stringout = StringOutManager.getInstance(StringOutType.JSON);

String value = stringout.find("id");
```

### Par�metros

Par�metros tamb�m podem ser passados no momento da busca para que sejam processados e substitu�dos dentro da string localizada.
Ex: 

```java
StringOut stringout = StringOutManager.getInstance(StringOutType.JSON);

Map<String, String> replacements = new HashMap<String, String>();
replacements.put("nome", "Diego Pessoa");
			
String value = stringout.find("id", replacements);
``` 

Dentro da String de destino, a sintaxe que deve se seguida para utiliza��o de par�metros, � como se segue:

```java
Meu nome � :nome
```

Ou seja, sempre que se desejar passar par�metros, a sintaxe ":" deve ser utilizada antes da palavra que se deseja substituir.


### Tipos de Arquivos Externos

Stringout aceita 3 tipos diferentes de arquivos externos para se poder ler dados.

	* JSON
	* PROPERTY
	* XML (Ainda em implementa��o)

	




	
